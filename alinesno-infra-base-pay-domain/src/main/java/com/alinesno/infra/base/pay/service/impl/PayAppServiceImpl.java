package com.alinesno.infra.base.pay.service.impl;

import com.alinesno.infra.base.pay.entity.PayAppEntity;
import com.alinesno.infra.base.pay.enums.ProviderChannelEnum;
import com.alinesno.infra.base.pay.mapper.PayAppMapper;
import com.alinesno.infra.base.pay.service.IPayAppService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.alinesno.infra.common.facade.enums.HasStatusEnums;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.sqids.Sqids;

import java.util.Arrays;
import java.util.List;

/**
 * 资产编目Service业务层处理
 *
 * @author luoxiaodong
 * @since 1.0.0
 */
@Slf4j
@Service
public class PayAppServiceImpl extends IBaseServiceImpl<PayAppEntity, PayAppMapper> implements IPayAppService {
    private static final String DEFAULT_PROJECT_FIELD = "default" ;

    /**
     * 获取支持的类型
     * @param appCode
     * @return
     */
    @Override
    public List<String> getDocumentType(String appCode) {

        PayAppEntity e = getOne(new LambdaQueryWrapper<PayAppEntity>().eq(PayAppEntity::getProjectCode , appCode)) ;

        if(e.getHasStatus() == HasStatusEnums.ILLEGAL.value){
            return List.of();
        }

        String documentStr = e.getDocumentType() ;

        return Arrays.asList(documentStr.split(","));
    }

    @Override
    public void saveDocumentType(String projectId, String documentStr) {

        PayAppEntity e = getById(projectId) ;
        e.setDocumentType(documentStr);

    }

    @Override
    public void initDefaultApp(long userId) {

        Sqids sqids=Sqids.builder().build();
        String code = sqids.encode(Arrays.asList(1L,2L,3L)); // "86Rf07"

        PayAppEntity project = new PayAppEntity() ;

        project.setOperatorId(userId);
        project.setFieldProp(DEFAULT_PROJECT_FIELD);

        project.setProjectName("默认监控应用");
        project.setProjectDesc("包含所有的监控渠道查看权限，用于开发和验证场景");
        project.setProjectCode(code);
        project.setDocumentType(ProviderChannelEnum.getAllNameStr());

        save(project) ;
    }

    /**
     * 根据用户ID获取默认项目。
     *
     * @param userId 用户的ID，用于查询操作人与项目的关系。
     * @return 返回满足条件的默认项目实体，如果不存在，则返回null。
     *
     * 此方法通过查询满足特定条件（默认项目字段和操作人ID）的项目实体来实现。
     * 使用LambdaQueryWrapper来构建查询条件，以简化代码并提高可读性。
     */
    @Override
    public PayAppEntity getDefaultProject(long userId) {
        return getOne(new LambdaQueryWrapper<PayAppEntity>()
                .eq(PayAppEntity::getFieldProp , DEFAULT_PROJECT_FIELD)
                .eq(PayAppEntity::getOperatorId , userId));
    }

    /**
     * 检查项目是否处于合法状态。
     *
     * 本方法通过项目代码查询项目信息，并判断该项目的状态是否为合法状态。
     * 使用LambdaQueryWrapper进行条件查询，提高了代码的可读性和简洁性。
     *
     * @param projectCode 项目的唯一标识代码。
     * @return 如果项目处于合法状态，则返回true；否则返回false。
     */
    @Override
    public boolean isOpen(String projectCode) {
        // 根据项目代码查询项目实体
        PayAppEntity project = getOne(new LambdaQueryWrapper<PayAppEntity>()
                .eq(PayAppEntity::getProjectCode, projectCode));

        // 判断项目的状态是否为合法状态，返回相应的布尔值
        return project.getHasStatus() == HasStatusEnums.LEGAL.value;
    }
}

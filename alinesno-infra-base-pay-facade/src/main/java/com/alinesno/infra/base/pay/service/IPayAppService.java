package com.alinesno.infra.base.pay.service;


import com.alinesno.infra.base.pay.entity.PayAppEntity;
import com.alinesno.infra.common.facade.services.IBaseService;

import java.util.List;

/**
 *
 * @author luoxiaodong
 * @since 1.0.0
 */
public interface IPayAppService extends IBaseService<PayAppEntity> {

    /**
     * 获取当前应用支持的文档类型
     * @param appCode
     * @return
     */
    List<String> getDocumentType(String appCode);

    /**
     * 保存应用文档类型
     * @param documentStr
     */
    void saveDocumentType(String projectId , String documentStr) ;

    /**
     * 初始化默认应用
     * @param userId
     */
    void initDefaultApp(long userId);

    /**
     * 获取到默认应用标识
     * @return
     */
    PayAppEntity getDefaultProject(long userId);

    /**
     * 判断应用是否开启
     * @param projectCode
     * @return
     */
    boolean isOpen(String projectCode);

}

package com.alinesno.infra.base.pay.service.impl;

import com.alinesno.infra.base.pay.entity.PayChannelEntity;
import com.alinesno.infra.base.pay.enums.PayChannelEnum;
import com.alinesno.infra.base.pay.mapper.PayChannelMapper;
import com.alinesno.infra.base.pay.service.IPayChannelService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author LuoXiaoDong
 * @version 1.0.0
 */
@Slf4j
@Service
public class PayChannelServiceImpl extends IBaseServiceImpl<PayChannelEntity , PayChannelMapper> implements IPayChannelService {

    @Override
    public boolean isOpenType(String suffix) {

        LambdaQueryWrapper<PayChannelEntity> wrapper = new LambdaQueryWrapper<>() ;
        wrapper.eq(PayChannelEntity::getIsOpen , 1)
                .eq(PayChannelEntity::getChannelName, suffix.toUpperCase()) ;

        long count = count(wrapper) ;

        return count > 0 ;
    }

    @Override
    public void initPayChannel(long userId) {

        List<PayChannelEntity> documentTypes = new ArrayList<>();

        for(PayChannelEnum type : PayChannelEnum.getAllDocumentTypes()){

            PayChannelEntity typeE = new PayChannelEntity(
                    type.getIcon(),
                    type.getName(),
                    type.getDesc(), true, 100, false) ;

            typeE.setOperatorId(userId);

            documentTypes.add(typeE) ;
        }

        this.remove(new LambdaQueryWrapper<PayChannelEntity>()
                .eq(PayChannelEntity::getOperatorId, userId)
                .in(PayChannelEntity::getChannelName , PayChannelEnum.getAllNames())) ;

        saveBatch(documentTypes) ;
    }
}

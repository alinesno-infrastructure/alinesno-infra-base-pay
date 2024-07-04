package com.alinesno.infra.base.pay.service;

import com.alinesno.infra.base.pay.entity.PayChannelEntity;
import com.alinesno.infra.common.facade.services.IBaseService;

/**
 * 告警信息Service接口
 *
 * @version 1.0.0
 * @author luoxiaodong
 */
public interface IPayChannelService extends IBaseService<PayChannelEntity> {

    /**
     * 判断是否打开此类型
     * @param suffix
     * @return
     */
    boolean isOpenType(String suffix);

    /**
     * 初始化文档结构
     * @param userId
     */
    void initPayChannel(long userId);

}

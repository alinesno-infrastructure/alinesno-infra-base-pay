package com.alinesno.infra.base.pay.service.impl;

import com.alinesno.infra.base.pay.entity.PayOrderEntity;
import com.alinesno.infra.base.pay.mapper.PayOrderMapper;
import com.alinesno.infra.base.pay.service.IPayOrderService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 资产编目Service业务层处理
 *
 * @author luoxiaodong
 * @since 1.0.0
 */
@Slf4j
@Service
public class PayOrderServiceImpl extends IBaseServiceImpl<PayOrderEntity, PayOrderMapper> implements IPayOrderService {

}

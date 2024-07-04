package com.alinesno.infra.base.pay.service.impl;

import com.alinesno.infra.base.pay.entity.TransferOrderEntity;
import com.alinesno.infra.base.pay.mapper.TransferOrderMapper;
import com.alinesno.infra.base.pay.service.ITransferOrderService;
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
public class TransferOrderServiceImpl extends IBaseServiceImpl<TransferOrderEntity, TransferOrderMapper> implements ITransferOrderService {

}

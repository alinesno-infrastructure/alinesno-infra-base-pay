package com.alinesno.infra.base.pay.mapper;


import com.alinesno.infra.base.pay.entity.PayAppEntity;
import com.alinesno.infra.common.facade.mapper.repository.IBaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 资产编目Mapper接口
 *
 * @author luoxiaodong
 * @since 1.0.0
 */
@Mapper
public interface PayAppMapper extends IBaseMapper<PayAppEntity> {
}

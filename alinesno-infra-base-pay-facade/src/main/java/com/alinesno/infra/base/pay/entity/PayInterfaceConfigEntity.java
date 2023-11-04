package com.alinesno.infra.base.pay.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;

/**
 * 功能名：支付接口配置实体类
 * 数据表：pay_interface_config
 * 表备注：支付接口配置表
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@TableName("pay_interface_config")
@Data
public class PayInterfaceConfigEntity extends InfraBaseEntity {

    /**
     * 账号类型:1-服务商 2-商户 3-商户应用
     */
    @TableField("info_type")
	@ColumnType(length=255)
	@ColumnComment("账号类型:1-服务商")
    private Long infoType;

    /**
     * 服务商号/商户号/应用ID
     */
    @TableField("info_id")
	@ColumnType(length=255)
	@ColumnComment("服务商号/商户号/应用ID")
    private String infoId;

    /**
     * 支付接口代码
     */
    @TableField("if_code")
	@ColumnType(length=255)
	@ColumnComment("支付接口代码")
    private String ifCode;

    /**
     * 接口配置参数,TEXT字符串
     */
    @TableField("if_params")
	@ColumnType(length=255)
	@ColumnComment("接口配置参数,TEXT字符串")
    private String ifParams;

    /**
     * 支付接口费率
     */
    @TableField("if_rate")
	@ColumnType(length=255)
	@ColumnComment("支付接口费率")
    private BigDecimal ifRate;

    /**
     * 状态: 0-停用, 1-启用
     */
    @TableField("state")
	@ColumnType(length=255)
	@ColumnComment("状态:")
    private Long state;

    /**
     * 备注
     */
    @TableField("remark")
	@ColumnType(length=255)
	@ColumnComment("备注")
    private String remark;
}

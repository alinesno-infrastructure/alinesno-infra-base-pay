package com.alinesno.infra.base.pay.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * 功能名：商户支付通道实体类
 * 数据表：mch_pay_passage
 * 表备注：
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@TableName("mch_pay_passage")
@Data
public class MchPayPassageEntity extends InfraBaseEntity {

    /**
     * 商户号
     */
    @Excel(name = "商户号")
    @TableField("mch_no")
	@ColumnType(length=255)
	@ColumnComment("商户号")
    private String mchNo;

    /**
     * 应用ID
     */
    @Excel(name = "应用ID")
    @TableField("app_id")
	@ColumnType(length=255)
	@ColumnComment("应用ID")
    private String appId;

    /**
     * 支付接口
     */
    @Excel(name = "支付接口")
    @TableField("if_code")
	@ColumnType(length=255)
	@ColumnComment("支付接口")
    private String ifCode;

    /**
     * 支付方式
     */
    @Excel(name = "支付方式")
    @TableField("way_code")
	@ColumnType(length=255)
	@ColumnComment("支付方式")
    private String wayCode;

    /**
     * 支付方式费率
     */
    @Excel(name = "支付方式费率")
    @TableField("rate")
	@ColumnType(length=255)
	@ColumnComment("支付方式费率")
    private BigDecimal rate;

    /**
     * 风控数据
     */
    @Excel(name = "风控数据")
    @TableField("risk_config")
	@ColumnType(length=255)
	@ColumnComment("风控数据")
    private String riskConfig;

    /**
     * 状态: 0-停用, 1-启用
     */
    @Excel(name = "状态: 0-停用, 1-启用")
    @TableField("state")
	@ColumnType(length=255)
	@ColumnComment("状态:")
    private Long state;
}

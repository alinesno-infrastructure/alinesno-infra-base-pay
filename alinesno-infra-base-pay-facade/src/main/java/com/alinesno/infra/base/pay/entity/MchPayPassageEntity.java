package com.alinesno.infra.base.pay.entity;

import java.math.BigDecimal;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * 功能名：商户支付通道实体类
 * 数据表：mch_pay_passage
 * 表备注：
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@TableName("mch_pay_passage")
public class MchPayPassageEntity extends InfraBaseEntity {

    /**
     * 商户号
     */
    @Excel(name = "商户号")
    @TableField("mch_no")
    private String mchNo;

    /**
     * 应用ID
     */
    @Excel(name = "应用ID")
    @TableField("app_id")
    private String appId;

    /**
     * 支付接口
     */
    @Excel(name = "支付接口")
    @TableField("if_code")
    private String ifCode;

    /**
     * 支付方式
     */
    @Excel(name = "支付方式")
    @TableField("way_code")
    private String wayCode;

    /**
     * 支付方式费率
     */
    @Excel(name = "支付方式费率")
    @TableField("rate")
    private BigDecimal rate;

    /**
     * 风控数据
     */
    @Excel(name = "风控数据")
    @TableField("risk_config")
    private String riskConfig;

    /**
     * 状态: 0-停用, 1-启用
     */
    @Excel(name = "状态: 0-停用, 1-启用")
    @TableField("state")
    private Long state;

    // Getter and Setter methods

    public String getMchNo() {
        return this.mchNo;
    }

    public MchPayPassageEntity setMchNo(String mchNo) {
        this.mchNo = mchNo;
        return this;
    }

    public String getAppId() {
        return this.appId;
    }

    public MchPayPassageEntity setAppId(String appId) {
        this.appId = appId;
        return this;
    }

    public String getIfCode() {
        return this.ifCode;
    }

    public MchPayPassageEntity setIfCode(String ifCode) {
        this.ifCode = ifCode;
        return this;
    }

    public String getWayCode() {
        return this.wayCode;
    }

    public MchPayPassageEntity setWayCode(String wayCode) {
        this.wayCode = wayCode;
        return this;
    }

    public BigDecimal getRate() {
        return this.rate;
    }

    public MchPayPassageEntity setRate(BigDecimal rate) {
        this.rate = rate;
        return this;
    }

    public String getRiskConfig() {
        return this.riskConfig;
    }

    public MchPayPassageEntity setRiskConfig(String riskConfig) {
        this.riskConfig = riskConfig;
        return this;
    }

    public Long getState() {
        return this.state;
    }

    public MchPayPassageEntity setState(Long state) {
        this.state = state;
        return this;
    }
}

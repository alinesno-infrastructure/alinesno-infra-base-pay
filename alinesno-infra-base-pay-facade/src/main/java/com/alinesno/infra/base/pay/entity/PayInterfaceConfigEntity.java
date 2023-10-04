package com.alinesno.infra.base.pay.entity;

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
public class PayInterfaceConfigEntity extends InfraBaseEntity {

    /**
     * 账号类型:1-服务商 2-商户 3-商户应用
     */
    @TableField("info_type")
    private Long infoType;

    /**
     * 服务商号/商户号/应用ID
     */
    @TableField("info_id")
    private String infoId;

    /**
     * 支付接口代码
     */
    @TableField("if_code")
    private String ifCode;

    /**
     * 接口配置参数,TEXT字符串
     */
    @TableField("if_params")
    private String ifParams;

    /**
     * 支付接口费率
     */
    @TableField("if_rate")
    private BigDecimal ifRate;

    /**
     * 状态: 0-停用, 1-启用
     */
    @TableField("state")
    private Long state;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

    // Getter and Setter methods

    public Long getInfoType() {
        return this.infoType;
    }

    public void setInfoType(Long infoType) {
        this.infoType = infoType;
    }

    public String getInfoId() {
        return this.infoId;
    }

    public void setInfoId(String infoId) {
        this.infoId = infoId;
    }

    public String getIfCode() {
        return this.ifCode;
    }

    public void setIfCode(String ifCode) {
        this.ifCode = ifCode;
    }

    public String getIfParams() {
        return this.ifParams;
    }

    public void setIfParams(String ifParams) {
        this.ifParams = ifParams;
    }

    public BigDecimal getIfRate() {
        return this.ifRate;
    }

    public void setIfRate(BigDecimal ifRate) {
        this.ifRate = ifRate;
    }

    public Long getState() {
        return this.state;
    }

    public void setState(Long state) {
        this.state = state;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}

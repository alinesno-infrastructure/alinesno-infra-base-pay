package com.alinesno.infra.base.pay.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * 功能名：【请填写功能名称】
 * 数据表：mch_app
 * 表备注：
 * 
 * 数据表字段注释：
 * - appId：应用ID
 * - appName：应用名称
 * - mchNo：商户号
 * - state：应用状态: 0-停用, 1-正常
 * - appSecret：应用私钥
 * - payIfCode：支付接口code
 * - isvParams：支付接口参数配置
 * - remark：备注
 * 
 * 使用mybatis-plus的@TableName @TableField属性进行注解
 * 
 * 注意事项：
 * - @TableField不允许重复
 * - @TableField没有length属性
 * - @TableField的value属性应该直接写在注解中，而不是作为value参数传递
 * - 类的字段也需要添加中文注释信息
 * 
 * 作者：zhuoguangming
 * 创建时间：2021-07-29 13:37:59
 */
@TableName("mch_app")
public class MchAppEntity extends InfraBaseEntity {

    // fields

    /**
     * 应用ID
     */
    @Excel(name = "应用ID")
    @TableField("app_id")
    private String appId;

    /**
     * 应用名称
     */
    @Excel(name = "应用名称")
    @TableField("app_name")
    private String appName;

    /**
     * 商户号
     */
    @Excel(name = "商户号")
    @TableField("mch_no")
    private String mchNo;

    /**
     * 应用状态: 0-停用, 1-正常
     */
    @Excel(name = "应用状态: 0-停用, 1-正常")
    @TableField("state")
    private Long state;

    /**
     * 应用私钥
     */
    @Excel(name = "应用私钥")
    @TableField("app_secret")
    private String appSecret;

    /**
     * 支付接口code
     */
    @Excel(name = "pay_if_code")
    @TableField("pay_if_code")
    private String payIfCode;

    /**
     * 支付接口参数配置
     */
    @Excel(name = "isv_params")
    @TableField(value = "isv_params", typeHandler = com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler.class)
    private String isvParams;

    /**
     * 备注
     */
    @Excel(name = "备注")
    @TableField("remark")
    private String remark;

    // getter and setter

    public String getAppId() {
        return this.appId;
    }

    public MchAppEntity setAppId(String appId) {
        this.appId = appId;
        return this;
    }

    public String getAppName() {
        return this.appName;
    }

    public MchAppEntity setAppName(String appName) {
        this.appName = appName;
        return this;
    }

    public String getMchNo() {
        return this.mchNo;
    }

    public MchAppEntity setMchNo(String mchNo) {
        this.mchNo = mchNo;
        return this;
    }

    public Long getState() {
        return this.state;
    }

    public MchAppEntity setState(Long state) {
        this.state = state;
        return this;
    }

    public String getAppSecret() {
        return this.appSecret;
    }

    public MchAppEntity setAppSecret(String appSecret) {
        this.appSecret = appSecret;
        return this;
    }

    public String getPayIfCode() {
        return payIfCode;
    }

    public MchAppEntity setPayIfCode(String payIfCode) {
        this.payIfCode = payIfCode;
        return this;
    }

    public String getIsvParams() {
        return isvParams;
    }

    public MchAppEntity setIsvParams(String isvParams) {
        this.isvParams = isvParams;
        return this;
    }

    public String getRemark() {
        return this.remark;
    }

}
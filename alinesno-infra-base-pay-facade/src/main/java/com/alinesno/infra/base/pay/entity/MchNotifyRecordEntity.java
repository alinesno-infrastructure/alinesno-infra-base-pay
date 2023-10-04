package com.alinesno.infra.base.pay.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

/**
 * 功能名：商户通知记录实体类
 * 数据表：mch_notify_record
 * 表备注：
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@TableName("mch_notify_record")
public class MchNotifyRecordEntity extends InfraBaseEntity {

    /**
     * 商户通知记录ID
     */
    @Excel(name = "商户通知记录ID")
    @TableField("notify_id")
    private Long notifyId;

    /**
     * 订单ID
     */
    @Excel(name = "订单ID")
    @TableField("order_id")
    private String orderId;

    /**
     * 订单类型:1-支付,2-退款
     */
    @Excel(name = "订单类型:1-支付,2-退款")
    @TableField("order_type")
    private Long orderType;

    /**
     * 商户订单号
     */
    @Excel(name = "商户订单号")
    @TableField("mch_order_no")
    private String mchOrderNo;

    /**
     * 商户号
     */
    @Excel(name = "商户号")
    @TableField("mch_no")
    private String mchNo;

    /**
     * 服务商号
     */
    @Excel(name = "服务商号")
    @TableField("isv_no")
    private String isvNo;

    /**
     * 应用ID
     */
    @Excel(name = "应用ID")
    @TableField("app_id")
    private String appId;

    /**
     * 通知地址
     */
    @Excel(name = "通知地址")
    @TableField("notify_url")
    private String notifyUrl;

    /**
     * 通知响应结果
     */
    @Excel(name = "通知响应结果")
    @TableField("res_result")
    private String resResult;

    /**
     * 通知次数
     */
    @Excel(name = "通知次数")
    @TableField("notify_count")
    private Long notifyCount;

    /**
     * 最大通知次数, 默认6次
     */
    @Excel(name = "最大通知次数, 默认6次")
    @TableField("notify_count_limit")
    private Long notifyCountLimit;

    /**
     * 通知状态,1-通知中,2-通知成功,3-通知失败
     */
    @Excel(name = "通知状态,1-通知中,2-通知成功,3-通知失败")
    @TableField("state")
    private Long state;

    /**
     * 最后一次通知时间
     */
    @Excel(name = "最后一次通知时间", exportFormat = "yyyy-MM-dd")
    @TableField("last_notify_time")
    private Date lastNotifyTime;

// Getter and Setter methods

    public Long getNotifyId() {
        return this.notifyId;
    }

    public MchNotifyRecordEntity setNotifyId(Long notifyId) {
        this.notifyId = notifyId;
        return this;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public MchNotifyRecordEntity setOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public Long getOrderType() {
        return this.orderType;
    }

    public MchNotifyRecordEntity setOrderType(Long orderType) {
        this.orderType = orderType;
        return this;
    }

    public String getMchOrderNo() {
        return this.mchOrderNo;
    }

    public MchNotifyRecordEntity setMchOrderNo(String mchOrderNo) {
        this.mchOrderNo = mchOrderNo;
        return this;
    }

    public String getMchNo() {
        return this.mchNo;
    }

    public MchNotifyRecordEntity setMchNo(String mchNo) {
        this.mchNo = mchNo;
        return this;
    }

    public String getIsvNo() {
        return this.isvNo;
    }

    public MchNotifyRecordEntity setIsvNo(String isvNo) {
        this.isvNo = isvNo;
        return this;
    }

    public String getAppId() {
        return this.appId;
    }

    public MchNotifyRecordEntity setAppId(String appId) {
        this.appId = appId;
        return this;
    }

    public String getNotifyUrl() {
        return this.notifyUrl;
    }

    public MchNotifyRecordEntity setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
        return this;
    }

    public String getResResult() {
        return this.resResult;
    }

    public MchNotifyRecordEntity setResResult(String resResult) {
        this.resResult = resResult;
        return this;
    }

    public Long getNotifyCount() {
        return this.notifyCount;
    }

    public MchNotifyRecordEntity setNotifyCount(Long notifyCount) {
        this.notifyCount = notifyCount;
        return this;
    }

    public Long getNotifyCountLimit() {
        return this.notifyCountLimit;
    }

    public MchNotifyRecordEntity setNotifyCountLimit(Long notifyCountLimit) {
        this.notifyCountLimit = notifyCountLimit;
        return this;
    }

    public Long getState() {
        return this.state;
    }

    public MchNotifyRecordEntity setState(Long state) {
        this.state = state;
        return this;
    }

    public Date getLastNotifyTime() {
        return this.lastNotifyTime;
    }

    public MchNotifyRecordEntity setLastNotifyTime(Date lastNotifyTime) {
        this.lastNotifyTime = lastNotifyTime;
        return this;
    }
}


package com.alinesno.infra.base.notice.entity;

import java.util.Date;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 功能名：退款订单实体类
 * 数据表：refund_order
 * 表备注：退款订单表
 * 
 * 注意：
 * 1. @TableField不允许重复。
 * 2. @TableField没有length属性。
 * 3. InfraBaseEntity的路径为com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity。
 * 4. 字段需要添加中文注释信息。
 * 5. 类需要添加详细的注释信息。
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@TableName("refund_order")
public class RefundOrderEntity extends InfraBaseEntity {

    /**
     * 退款订单号（支付系统生成订单号）
     */
    @TableField("refund_order_id")
    private String refundOrderId;

    /**
     * 支付订单号（与pay_order对应）
     */
    @TableField("pay_order_id")
    private String payOrderId;

    /**
     * 渠道支付单号（与pay_order channel_order_no对应）
     */
    @TableField("channel_pay_order_no")
    private String channelPayOrderNo;

    /**
     * 商户号
     */
    @TableField("mch_no")
    private String mchNo;

    /**
     * 服务商号
     */
    @TableField("isv_no")
    private String isvNo;

    /**
     * 应用ID
     */
    @TableField("app_id")
    private String appId;

    /**
     * 商户名称
     */
    @TableField("mch_name")
    private String mchName;

    /**
     * 类型: 1-普通商户, 2-特约商户(服务商模式)
     */
    @TableField("mch_type")
    private Long mchType;

    /**
     * 商户退款单号（商户系统的订单号）
     */
    @TableField("mch_refund_no")
    private String mchRefundNo;

    /**
     * 支付方式代码
     */
    @TableField("way_code")
    private String wayCode;

    /**
     * 支付接口代码
     */
    @TableField("if_code")
    private String ifCode;

    /**
     * 支付金额,单位分
     */
    @TableField("pay_amount")
    private Long payAmount;

    /**
     * 退款金额,单位分
     */
    @TableField("refund_amount")
    private Long refundAmount;

    /**
     * 三位货币代码,人民币:cny
     */
    @TableField("currency")
    private String currency;

    /**
     * 退款状态:0-订单生成,1-退款中,2-退款成功,3-退款失败,4-退款任务关闭
     */
    @TableField("state")
    private Long state;

    /**
     * 客户端IP
     */
    @TableField("client_ip")
    private String clientIp;

    /**
     * 退款原因
     */
    @TableField("refund_reason")
    private String refundReason;

    /**
     * 渠道订单号
     */
    @TableField("channel_order_no")
    private String channelOrderNo;

    /**
     * 渠道错误码
     */
    @TableField("err_code")
    private String errCode;

    /**
     * 渠道错误描述
     */
    @TableField("err_msg")
    private String errMsg;

    /**
     * 特定渠道发起时额外参数
     */
    @TableField("channel_extra")
    private String channelExtra;

    /**
     * 通知地址
     */
    @TableField("notify_url")
    private String notifyUrl;

    /**
     * 扩展参数
     */
    @TableField("ext_param")
    private String extParam;

    /**
     * 订单退款成功时间
     */
    @TableField("success_time")
    private Date successTime;
    /**
     * 退款失效时间（失效后系统更改为退款任务关闭状态）
     */
    @Excel(name = "退款失效时间（失效后系统更改为退款任务关闭状态）", exportFormat = "yyyy-MM-dd")
    @TableField("expired_time")
    private Date expiredTime;
}

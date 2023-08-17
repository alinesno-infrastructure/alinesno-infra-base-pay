package com.alinesno.infra.base.notice.entity;

import java.util.Date;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 功能名：支付订单实体类
 * 数据表：pay_order
 * 表备注：支付订单表
 * 
 * 注意：以下字段的注释为中文注释
 * 
 * 字段说明：
 * - 支付订单号
 * - 商户号
 * - 服务商号
 * - 应用ID
 * - 商户名称
 * - 类型：1-普通商户，2-特约商户(服务商模式)
 * - 商户订单号
 * - 支付接口代码
 * - 支付方式代码
 * - 支付金额，单位分
 * - 三位货币代码，人民币:cny
 * - 支付状态：0-订单生成，1-支付中，2-支付成功，3-支付失败，4-已撤销，5-已退款，6-订单关闭
 * - 向下游回调状态：0-未发送，1-已发送
 * - 客户端IP
 * - 商品标题
 * - 商品描述信息
 * - 特定渠道发起额外参数
 * - 渠道用户标识，如微信openId，支付宝账号
 * - 渠道订单号
 * - 退款状态：0-未发生实际退款，1-部分退款，2-全额退款
 * - 退款次数
 * - 退款总金额，单位分
 * - 订单分账标志：0-否，1-是
 * - 预计分账发起时间
 * - 渠道支付错误码
 * - 渠道支付错误描述
 * - 商户扩展参数
 * - 异步通知地址
 * - 页面跳转地址
 * - 订单失效时间
 * - 订单支付成功时间
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@TableName("pay_order")
public class PayOrderEntity extends InfraBaseEntity {

    /**
     * 支付订单号
     */
    @TableField("pay_order_id")
    private String payOrderId;

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
     * 商户订单号
     */
    @TableField("mch_order_no")
    private String mchOrderNo;

    /**
     * 支付接口代码
     */
    @TableField("if_code")
    private String ifCode;

    /**
     * 支付方式代码
     */
    @TableField("way_code")
    private String wayCode;

    /**
     * 支付金额,单位分
     */
    @TableField("amount")
    private Long amount;

    /**
     * 三位货币代码,人民币:cny
     */
    @TableField("currency")
    private String currency;

    /**
     * 支付状态: 0-订单生成, 1-支付中, 2-支付成功, 3-支付失败, 4-已撤销, 5-已退款, 6-订单关闭
     */
    @TableField("state")
    private Long state;

    /**
     * 向下游回调状态, 0-未发送,  1-已发送
     */
    @TableField("notify_state")
    private Long notifyState;

    /**
     * 客户端IP
     */
    @TableField("client_ip")
    private String clientIp;

    /**
     * 商品标题
     */
    @TableField("subject")
    private String subject;

    /**
     * 商品描述信息
     */
    @TableField("body")
    private String body;

    /**
     * 特定渠道发起额外参数
     */
    @TableField("channel_extra")
    private String channelExtra;

    /**
     * 渠道用户标识,如微信openId,支付宝账号
     */
    @TableField("channel_user")
    private String channelUser;

    /**
     * 渠道订单号
     */
    @TableField("channel_order_no")
    private String channelOrderNo;

    /**
     * 退款状态: 0-未发生实际退款, 1-部分退款, 2-全额退款
     */
    @TableField("refund_state")
    private Long refundState;

    /**
     * 退款次数
     */
    @TableField("refund_times")
    private Long refundTimes;

    /**
     * 退款总金额,单位分
     */
    @TableField("refund_amount")
    private Long refundAmount;

    /**
     * 订单分账标志：0-否  1-是
     */
    @TableField("division_flag")
    private Long divisionFlag;

    /**
     * 预计分账发起时间
     */
    @TableField("division_time")
    private Date divisionTime;

    /**
     * 渠道支付错误码
     */
    @TableField("err_code")
    private String errCode;

    /**
     * 渠道支付错误描述
     */
    @TableField("err_msg")
    private String errMsg;

    /**
     * 商户扩展参数
     */
    @TableField("ext_param")
    private String extParam;

    /**
     * 异步通知地址
     */
    @TableField("notify_url")
    private String notifyUrl;

    /**
     * 页面跳转地址
     */
    @TableField("return_url")
    private String returnUrl;

    /**
     * 订单失效时间
     */
    @TableField("expired_time")
    private Date expiredTime;

    /**
     * 订单支付成功时间
     */
    @Excel(name = "订单支付成功时间", exportFormat = "yyyy-MM-dd")
    @TableField("success_time")
    private Date successTime;
    //getter and setter
}

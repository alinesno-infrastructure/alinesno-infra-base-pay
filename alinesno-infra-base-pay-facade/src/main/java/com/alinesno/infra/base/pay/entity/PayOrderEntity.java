package com.alinesno.infra.base.pay.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.EqualsAndHashCode;

import java.util.Date;

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
@EqualsAndHashCode(callSuper = true)
@TableName("pay_order")
@Data
public class PayOrderEntity extends InfraBaseEntity {

    /**
     * 支付订单号
     */
    @TableField("pay_order_id")
	@ColumnType(length=255)
	@ColumnComment("支付订单号")
    private String payOrderId;

    /**
     * 商户号
     */
    @TableField("mch_no")
	@ColumnType(length=255)
	@ColumnComment("商户号")
    private String mchNo;

    /**
     * 服务商号
     */
    @TableField("isv_no")
	@ColumnType(length=255)
	@ColumnComment("服务商号")
    private String isvNo;

    /**
     * 应用ID
     */
    @TableField("app_id")
	@ColumnType(length=255)
	@ColumnComment("应用ID")
    private String appId;

    /**
     * 商户名称
     */
    @TableField("mch_name")
	@ColumnType(length=255)
	@ColumnComment("商户名称")
    private String mchName;

    /**
     * 类型: 1-普通商户, 2-特约商户(服务商模式)
     */
    @TableField("mch_type")
	@ColumnType(length=255)
	@ColumnComment("类型:")
    private Long mchType;

    /**
     * 商户订单号
     */
    @TableField("mch_order_no")
	@ColumnType(length=255)
	@ColumnComment("商户订单号")
    private String mchOrderNo;

    /**
     * 支付接口代码
     */
    @TableField("if_code")
	@ColumnType(length=255)
	@ColumnComment("支付接口代码")
    private String ifCode;

    /**
     * 支付方式代码
     */
    @TableField("way_code")
	@ColumnType(length=255)
	@ColumnComment("支付方式代码")
    private String wayCode;

    /**
     * 支付金额,单位分
     */
    @TableField("amount")
	@ColumnType(length=255)
	@ColumnComment("支付金额,单位分")
    private Long amount;

    /**
     * 三位货币代码,人民币:cny
     */
    @TableField("currency")
	@ColumnType(length=255)
	@ColumnComment("三位货币代码,人民币:cny")
    private String currency;

    /**
     * 支付状态: 0-订单生成, 1-支付中, 2-支付成功, 3-支付失败, 4-已撤销, 5-已退款, 6-订单关闭
     */
    @TableField("state")
	@ColumnType(length=255)
	@ColumnComment("支付状态:")
    private Long state;

    /**
     * 向下游回调状态, 0-未发送,  1-已发送
     */
    @TableField("notify_state")
	@ColumnType(length=255)
	@ColumnComment("向下游回调状态,")
    private Long notifyState;

    /**
     * 客户端IP
     */
    @TableField("client_ip")
	@ColumnType(length=255)
	@ColumnComment("客户端IP")
    private String clientIp;

    /**
     * 商品标题
     */
    @TableField("subject")
	@ColumnType(length=255)
	@ColumnComment("商品标题")
    private String subject;

    /**
     * 商品描述信息
     */
    @TableField("body")
	@ColumnType(length=255)
	@ColumnComment("商品描述信息")
    private String body;

    /**
     * 特定渠道发起额外参数
     */
    @TableField("channel_extra")
	@ColumnType(length=255)
	@ColumnComment("特定渠道发起额外参数")
    private String channelExtra;

    /**
     * 渠道用户标识,如微信openId,支付宝账号
     */
    @TableField("channel_user")
	@ColumnType(length=255)
	@ColumnComment("渠道用户标识,如微信openId,支付宝账号")
    private String channelUser;

    /**
     * 渠道订单号
     */
    @TableField("channel_order_no")
	@ColumnType(length=255)
	@ColumnComment("渠道订单号")
    private String channelOrderNo;

    /**
     * 退款状态: 0-未发生实际退款, 1-部分退款, 2-全额退款
     */
    @TableField("refund_state")
	@ColumnType(length=255)
	@ColumnComment("退款状态:")
    private Long refundState;

    /**
     * 退款次数
     */
    @TableField("refund_times")
	@ColumnType(length=255)
	@ColumnComment("退款次数")
    private Long refundTimes;

    /**
     * 退款总金额,单位分
     */
    @TableField("refund_amount")
	@ColumnType(length=255)
	@ColumnComment("退款总金额,单位分")
    private Long refundAmount;

    /**
     * 订单分账标志：0-否  1-是
     */
    @TableField("division_flag")
	@ColumnType(length=255)
	@ColumnComment("订单分账标志：0-否")
    private Long divisionFlag;

    /**
     * 预计分账发起时间
     */
    @TableField("division_time")
	@ColumnType(length=255)
	@ColumnComment("预计分账发起时间")
    private Date divisionTime;

    /**
     * 渠道支付错误码
     */
    @TableField("err_code")
	@ColumnType(length=255)
	@ColumnComment("渠道支付错误码")
    private String errCode;

    /**
     * 渠道支付错误描述
     */
    @TableField("err_msg")
	@ColumnType(length=255)
	@ColumnComment("渠道支付错误描述")
    private String errMsg;

    /**
     * 商户扩展参数
     */
    @TableField("ext_param")
	@ColumnType(length=255)
	@ColumnComment("商户扩展参数")
    private String extParam;

    /**
     * 异步通知地址
     */
    @TableField("notify_url")
	@ColumnType(length=255)
	@ColumnComment("异步通知地址")
    private String notifyUrl;

    /**
     * 页面跳转地址
     */
    @TableField("return_url")
	@ColumnType(length=255)
	@ColumnComment("页面跳转地址")
    private String returnUrl;

    /**
     * 订单失效时间
     */
    @TableField("expired_time")
	@ColumnType(length=255)
	@ColumnComment("订单失效时间")
    private Date expiredTime;

    /**
     * 订单支付成功时间
     */
    @Excel(name = "订单支付成功时间", exportFormat = "yyyy-MM-dd")
    @TableField("success_time")
	@ColumnType(length=255)
	@ColumnComment("订单支付成功时间")
    private Date successTime;
}

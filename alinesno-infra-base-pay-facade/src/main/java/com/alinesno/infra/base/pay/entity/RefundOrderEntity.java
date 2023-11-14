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
@EqualsAndHashCode(callSuper = true)
@TableName("refund_order")
@Data
public class RefundOrderEntity extends InfraBaseEntity {

    /**
     * 退款订单号（支付系统生成订单号）
     */
    @TableField("refund_order_id")
	@ColumnType(length=255)
	@ColumnComment("退款订单号（支付系统生成订单号）")
    private String refundOrderId;

    /**
     * 支付订单号（与pay_order对应）
     */
    @TableField("pay_order_id")
	@ColumnType(length=255)
	@ColumnComment("支付订单号（与pay_order对应）")
    private String payOrderId;

    /**
     * 渠道支付单号（与pay_order channel_order_no对应）
     */
    @TableField("channel_pay_order_no")
	@ColumnType(length=255)
	@ColumnComment("渠道支付单号")
    private String channelPayOrderNo;

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
     * 商户退款单号（商户系统的订单号）
     */
    @TableField("mch_refund_no")
	@ColumnType(length=255)
	@ColumnComment("商户退款单号（商户系统的订单号）")
    private String mchRefundNo;

    /**
     * 支付方式代码
     */
    @TableField("way_code")
	@ColumnType(length=255)
	@ColumnComment("支付方式代码")
    private String wayCode;

    /**
     * 支付接口代码
     */
    @TableField("if_code")
	@ColumnType(length=255)
	@ColumnComment("支付接口代码")
    private String ifCode;

    /**
     * 支付金额,单位分
     */
    @TableField("pay_amount")
	@ColumnType(length=255)
	@ColumnComment("支付金额,单位分")
    private Long payAmount;

    /**
     * 退款金额,单位分
     */
    @TableField("refund_amount")
	@ColumnType(length=255)
	@ColumnComment("退款金额,单位分")
    private Long refundAmount;

    /**
     * 三位货币代码,人民币:cny
     */
    @TableField("currency")
	@ColumnType(length=255)
	@ColumnComment("三位货币代码,人民币:cny")
    private String currency;

    /**
     * 退款状态:0-订单生成,1-退款中,2-退款成功,3-退款失败,4-退款任务关闭
     */
    @TableField("state")
	@ColumnType(length=255)
	@ColumnComment("退款状态:0-订单生成,1-退款中,2-退款成功,3-退款失败,4-退款任务关闭")
    private Long state;

    /**
     * 客户端IP
     */
    @TableField("client_ip")
	@ColumnType(length=255)
	@ColumnComment("客户端IP")
    private String clientIp;

    /**
     * 退款原因
     */
    @TableField("refund_reason")
	@ColumnType(length=255)
	@ColumnComment("退款原因")
    private String refundReason;

    /**
     * 渠道订单号
     */
    @TableField("channel_order_no")
	@ColumnType(length=255)
	@ColumnComment("渠道订单号")
    private String channelOrderNo;

    /**
     * 渠道错误码
     */
    @TableField("err_code")
	@ColumnType(length=255)
	@ColumnComment("渠道错误码")
    private String errCode;

    /**
     * 渠道错误描述
     */
    @TableField("err_msg")
	@ColumnType(length=255)
	@ColumnComment("渠道错误描述")
    private String errMsg;

    /**
     * 特定渠道发起时额外参数
     */
    @TableField("channel_extra")
	@ColumnType(length=255)
	@ColumnComment("特定渠道发起时额外参数")
    private String channelExtra;

    /**
     * 通知地址
     */
    @TableField("notify_url")
	@ColumnType(length=255)
	@ColumnComment("通知地址")
    private String notifyUrl;

    /**
     * 扩展参数
     */
    @TableField("ext_param")
	@ColumnType(length=255)
	@ColumnComment("扩展参数")
    private String extParam;

    /**
     * 订单退款成功时间
     */
    @TableField("success_time")
	@ColumnType(length=255)
	@ColumnComment("订单退款成功时间")
    private Date successTime;
    /**
     * 退款失效时间（失效后系统更改为退款任务关闭状态）
     */
    @Excel(name = "退款失效时间（失效后系统更改为退款任务关闭状态）", exportFormat = "yyyy-MM-dd")
    @TableField("expired_time")
	@ColumnType(length=255)
	@ColumnComment("退款失效时间（失效后系统更改为退款任务关闭状态）")
    private Date expiredTime;
}

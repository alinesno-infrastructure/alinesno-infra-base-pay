package com.alinesno.infra.base.pay.entity;

import com.alinesno.infra.common.facade.mapper.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 转账订单实体类
 * author luoxiaodong
 * version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@TableName("transfer_order")
@Data
public class TransferOrderEntity extends BaseEntity {

    // 支付接口编码
    @TableField("if_code")
    @ColumnType(length=255)
    @ColumnComment("支付接口编码")
    private String ifCode;

    // 收款账户名称
    @TableField("account_name")
    @ColumnType(length=255)
    @ColumnComment("收款账户名称")
    private String accountName;

    // 商户订单号
    @TableField("mch_order_no")
    @ColumnType(length=255)
    @ColumnComment("商户订单号")
    private String mchOrderNo;

    // ISV编号
    @TableField("isv_no")
    @ColumnType(length=255)
    @ColumnComment("ISV编号")
    private String isvNo;

    // 收款账户号
    @TableField("account_no")
    @ColumnType(length=255)
    @ColumnComment("收款账户号")
    private String accountNo;

    // 应用ID
    @TableField("app_id")
    @ColumnType(length=255)
    @ColumnComment("应用ID")
    private String appId;

    // 货币类型
    @TableField("currency")
    @ColumnType(length=255)
    @ColumnComment("货币类型")
    private String currency;

    // 支付状态
    @TableField("state")
    @ColumnType(length=255)
    @ColumnComment("支付状态")
    private int state;

    // 商户号
    @TableField("mch_no")
    @ColumnType(length=255)
    @ColumnComment("商户号")
    private String mchNo;

    // 入账类型
    @TableField("entry_type")
    @ColumnType(length=255)
    @ColumnComment("入账类型")
    private String entryType;

    // 支付金额
    @TableField("amount")
    @ColumnType(length=255)
    @ColumnComment("支付金额")
    private int amount;

    // 商户名称
    @TableField("mch_name")
    @ColumnType(length=255)
    @ColumnComment("商户名称")
    private String mchName;

    // 转账描述
    @TableField("transfer_desc")
    @ColumnType(length=255)
    @ColumnComment("转账描述")
    private String transferDesc;

    // 转账ID
    @TableField("transfer_id")
    @ColumnType(length=255)
    @ColumnComment("转账ID")
    private String transferId;

    // 商户类型
    @TableField("mch_type")
    @ColumnType(length=255)
    @ColumnComment("商户类型")
    private int mchType;

    // 客户端IP
    @TableField("client_ip")
    @ColumnType(length=255)
    @ColumnComment("客户端IP")
    private String clientIp;

    // 异步通知地址
    @TableField("notify_url")
    @ColumnType(length=255)
    @ColumnComment("异步通知地址")
    private String notifyUrl;

}

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
 * 功能名：商户通知记录实体类
 * 数据表：mch_notify_record
 * 表备注：
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@TableName("mch_notify_record")
@Data
public class MchNotifyRecordEntity extends InfraBaseEntity {

    /**
     * 商户通知记录ID
     */
    @Excel(name = "商户通知记录ID")
    @TableField("notify_id")
    @ColumnType(length = 255)
    @ColumnComment("商户通知记录ID")
    private Long notifyId;

    /**
     * 订单ID
     */
    @Excel(name = "订单ID")
    @TableField("order_id")
    @ColumnType(length = 255)
    @ColumnComment("订单ID")
    private String orderId;

    /**
     * 订单类型:1-支付,2-退款
     */
    @Excel(name = "订单类型:1-支付,2-退款")
    @TableField("order_type")
    @ColumnType(length = 255)
    @ColumnComment("订单类型:1-支付,2-退款")
    private Long orderType;

    /**
     * 商户订单号
     */
    @Excel(name = "商户订单号")
    @TableField("mch_order_no")
    @ColumnType(length = 255)
    @ColumnComment("商户订单号")
    private String mchOrderNo;

    /**
     * 商户号
     */
    @Excel(name = "商户号")
    @TableField("mch_no")
    @ColumnType(length = 255)
    @ColumnComment("商户号")
    private String mchNo;

    /**
     * 服务商号
     */
    @Excel(name = "服务商号")
    @TableField("isv_no")
    @ColumnType(length = 255)
    @ColumnComment("服务商号")
    private String isvNo;

    /**
     * 应用ID
     */
    @Excel(name = "应用ID")
    @TableField("app_id")
    @ColumnType(length = 255)
    @ColumnComment("应用ID")
    private String appId;

    /**
     * 通知地址
     */
    @Excel(name = "通知地址")
    @TableField("notify_url")
    @ColumnType(length = 255)
    @ColumnComment("通知地址")
    private String notifyUrl;

    /**
     * 通知响应结果
     */
    @Excel(name = "通知响应结果")
    @TableField("res_result")
    @ColumnType(length = 255)
    @ColumnComment("通知响应结果")
    private String resResult;

    /**
     * 通知次数
     */
    @Excel(name = "通知次数")
    @TableField("notify_count")
    @ColumnType(length = 255)
    @ColumnComment("通知次数")
    private Long notifyCount;

    /**
     * 最大通知次数, 默认6次
     */
    @Excel(name = "最大通知次数, 默认6次")
    @TableField("notify_count_limit")
    @ColumnType(length = 255)
    @ColumnComment("最大通知次数,")
    private Long notifyCountLimit;

    /**
     * 通知状态,1-通知中,2-通知成功,3-通知失败
     */
    @Excel(name = "通知状态,1-通知中,2-通知成功,3-通知失败")
    @TableField("state")
    @ColumnType(length = 255)
    @ColumnComment("通知状态,1-通知中,2-通知成功,3-通知失败")
    private Long state;

    /**
     * 最后一次通知时间
     */
    @Excel(name = "最后一次通知时间", exportFormat = "yyyy-MM-dd")
    @TableField("last_notify_time")
    @ColumnType(length = 255)
    @ColumnComment("最后一次通知时间")
    private Date lastNotifyTime;
}
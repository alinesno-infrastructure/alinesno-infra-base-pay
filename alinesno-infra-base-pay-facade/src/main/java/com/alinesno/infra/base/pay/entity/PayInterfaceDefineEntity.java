package com.alinesno.infra.base.pay.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 功能名：支付接口定义实体类
 * 数据表：pay_interface_define
 * 表备注：支付接口定义表
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@TableName("pay_interface_define")
@Data
public class PayInterfaceDefineEntity extends InfraBaseEntity {

    /**
     * 接口代码 全小写  wxpay alipay
     */
    @TableField("if_code")
    @ColumnType(length = 255)
    @ColumnComment("接口代码")
    private String ifCode;

    /**
     * 接口名称
     */
    @TableField("if_name")
    @ColumnType(length = 255)
    @ColumnComment("接口名称")
    private String ifName;

    /**
     * 是否支持普通商户模式: 0-不支持, 1-支持
     */
    @TableField("is_mch_mode")
    @ColumnType(length = 255)
    @ColumnComment("是否支持普通商户模式:")
    private Long isMchMode;

    /**
     * 是否支持服务商子商户模式: 0-不支持, 1-支持
     */
    @TableField("is_isv_mode")
    @ColumnType(length = 255)
    @ColumnComment("是否支持服务商子商户模式:")
    private Long isIsvMode;

    /**
     * 支付参数配置页面类型:1-TEXT渲染,2-自定义
     */
    @TableField("config_page_type")
    @ColumnType(length = 255)
    @ColumnComment("支付参数配置页面类型:1-TEXT渲染,2-自定义")
    private Long configPageType;

    /**
     * ISV接口配置定义描述,TEXT字符串
     */
    @TableField("isv_params")
    @ColumnType(length = 255)
    @ColumnComment("ISV接口配置定义描述,TEXT字符串")
    private String isvParams;

    /**
     * 特约商户接口配置定义描述,TEXT字符串
     */
    @TableField("isvsub_mch_params")
    @ColumnType(length = 255)
    @ColumnComment("特约商户接口配置定义描述,TEXT字符串")
    private String isvsubMchParams;

    /**
     * 普通商户接口配置定义描述,TEXT字符串
     */
    @TableField("normal_mch_params")
    @ColumnType(length = 255)
    @ColumnComment("普通商户接口配置定义描述,TEXT字符串")
    private String normalMchParams;

    /**
     * 支持的支付方式 [wxpay_jsapi, wxpay_bar]
     */
    @TableField("way_codes")
    @ColumnType(length = 255)
    @ColumnComment("支持的支付方式")
    private String wayCodes;

    /**
     * 页面展示：卡片-图标
     */
    @TableField("icon")
    @ColumnType(length = 255)
    @ColumnComment("页面展示：卡片-图标")
    private String icon;

    /**
     * 页面展示：卡片-背景色
     */
    @TableField("bg_color")
    @ColumnType(length = 255)
    @ColumnComment("页面展示：卡片-背景色")
    private String bgColor;

    /**
     * 状态: 0-停用, 1-启用
     */
    @TableField("state")
    @ColumnType(length = 255)
    @ColumnComment("状态:")
    private Long state;

    /**
     * 备注
     */
    @TableField("remark")
    @ColumnType(length = 255)
    @ColumnComment("备注")
    private String remark;
}


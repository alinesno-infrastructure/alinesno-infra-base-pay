package com.alinesno.infra.base.notice.entity;

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
public class PayInterfaceDefineEntity extends InfraBaseEntity {

    /**
     * 接口代码 全小写  wxpay alipay
     */
    @TableField("if_code")
    private String ifCode;

    /**
     * 接口名称
     */
    @TableField("if_name")
    private String ifName;

    /**
     * 是否支持普通商户模式: 0-不支持, 1-支持
     */
    @TableField("is_mch_mode")
    private Long isMchMode;

    /**
     * 是否支持服务商子商户模式: 0-不支持, 1-支持
     */
    @TableField("is_isv_mode")
    private Long isIsvMode;

    /**
     * 支付参数配置页面类型:1-TEXT渲染,2-自定义
     */
    @TableField("config_page_type")
    private Long configPageType;

    /**
     * ISV接口配置定义描述,TEXT字符串
     */
    @TableField("isv_params")
    private String isvParams;

    /**
     * 特约商户接口配置定义描述,TEXT字符串
     */
    @TableField("isvsub_mch_params")
    private String isvsubMchParams;

    /**
     * 普通商户接口配置定义描述,TEXT字符串
     */
    @TableField("normal_mch_params")
    private String normalMchParams;

    /**
     * 支持的支付方式 [wxpay_jsapi, wxpay_bar]
     */
    @TableField("way_codes")
    private String wayCodes;

    /**
     * 页面展示：卡片-图标
     */
    @TableField("icon")
    private String icon;

    /**
     * 页面展示：卡片-背景色
     */
    @TableField("bg_color")
    private String bgColor;

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
    // ...
}


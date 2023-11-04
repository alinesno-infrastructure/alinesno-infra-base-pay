package com.alinesno.infra.base.pay.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

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
@Data
public class MchAppEntity extends InfraBaseEntity {

    // fields

    /**
     * 应用ID
     */
    @Excel(name = "应用ID")
    @TableField("app_id")
	@ColumnType(length=50)
	@ColumnComment("应用ID")
    private String appId;

    /**
     * 应用名称
     */
    @Excel(name = "应用名称")
    @TableField("app_name")
	@ColumnType(length=50)
	@ColumnComment("应用名称")
    private String appName;

    /**
     * 商户号
     */
    @Excel(name = "商户号")
    @TableField("mch_no")
	@ColumnType(length=20)
	@ColumnComment("商户号")
    private String mchNo;

    /**
     * 应用状态: 0-停用, 1-正常
     */
    @Excel(name = "应用状态: 0-停用, 1-正常")
    @TableField("state")
	@ColumnType(length=2)
	@ColumnComment("应用状态:")
    private Long state;

    /**
     * 应用私钥
     */
    @Excel(name = "应用私钥")
    @TableField("app_secret")
	@ColumnType(length=32)
	@ColumnComment("应用私钥")
    private String appSecret;

    /**
     * 支付接口code
     */
    @Excel(name = "pay_if_code")
    @TableField("pay_if_code")
	@ColumnType(length=50)
	@ColumnComment("支付接口code")
    private String payIfCode;

    /**
     * 支付接口参数配置
     */
    @Excel(name = "isv_params")
    @TableField(value = "isv_params", typeHandler = com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler.class)
	@ColumnType(length=255)
	@ColumnComment("支付接口参数配置")
    private String isvParams;

    /**
     * 备注
     */
    @Excel(name = "备注")
    @TableField("remark")
	@ColumnType(length=255)
	@ColumnComment("备注")
    private String remark;
}

package com.alinesno.infra.base.pay.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.EqualsAndHashCode;

/**
 * 功能名：商户信息实体类
 * 数据表：mch_info
 * 表备注：
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@TableName("mch_info")
@Data
public class MchInfoEntity extends InfraBaseEntity {

    /**
     * 商户号
     */
    @Excel(name = "商户号")
    @TableField("mch_no")
	@ColumnType(length=255)
	@ColumnComment("商户号")
    private String mchNo;

    /**
     * 商户名称
     */
    @Excel(name = "商户名称")
    @TableField("mch_name")
	@ColumnType(length=255)
	@ColumnComment("商户名称")
    private String mchName;

    /**
     * 商户简称
     */
    @Excel(name = "商户简称")
    @TableField("mch_short_name")
	@ColumnType(length=255)
	@ColumnComment("商户简称")
    private String mchShortName;

    /**
     * 类型: 1-普通商户, 2-特约商户(服务商模式)
     */
    @Excel(name = "类型: 1-普通商户, 2-特约商户(服务商模式)")
    @TableField("type")
	@ColumnType(length=255)
	@ColumnComment("类型:")
    private Long type;

    /**
     * 服务商号
     */
    @Excel(name = "服务商号")
    @TableField("isv_no")
	@ColumnType(length=255)
	@ColumnComment("服务商号")
    private String isvNo;

    /**
     * 联系人姓名
     */
    @Excel(name = "联系人姓名")
    @TableField("contact_name")
	@ColumnType(length=255)
	@ColumnComment("联系人姓名")
    private String contactName;

    /**
     * 联系人手机号
     */
    @Excel(name = "联系人手机号")
    @TableField("contact_tel")
	@ColumnType(length=255)
	@ColumnComment("联系人手机号")
    private String contactTel;

    /**
     * 联系人邮箱
     */
    @Excel(name = "联系人邮箱")
    @TableField("contact_email")
	@ColumnType(length=255)
	@ColumnComment("联系人邮箱")
    private String contactEmail;

    /**
     * 商户状态: 0-停用, 1-正常
     */
    @Excel(name = "商户状态: 0-停用, 1-正常")
    @TableField("state")
	@ColumnType(length=255)
	@ColumnComment("商户状态:")
    private Long state;

    /**
     * 商户备注
     */
    @Excel(name = "商户备注")
    @TableField("remark")
	@ColumnType(length=255)
	@ColumnComment("商户备注")
    private String remark;

    /**
     * 初始用户ID（创建商户时，允许商户登录的用户）
     */
    @Excel(name = "初始用户ID（创建商户时，允许商户登录的用户）")
    @TableField("init_user_id")
	@ColumnType(length=255)
	@ColumnComment("初始用户ID（创建商户时，允许商户登录的用户）")
    private Long initUserId;
}

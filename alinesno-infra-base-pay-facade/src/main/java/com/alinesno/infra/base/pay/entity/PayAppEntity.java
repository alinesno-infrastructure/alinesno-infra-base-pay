package com.alinesno.infra.base.pay.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.EqualsAndHashCode;

/**
 * 功能名：支付应用实体类
 * 数据表：pay_app
 * 表备注：
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@TableName("pay_app")
@Data
public class PayAppEntity extends InfraBaseEntity {

	/**
	 * 项目名称
	 */
	@TableField("project_name")
	@ColumnType(length=32)
	@ColumnComment("项目名称")
	private String projectName;

	/**
	 * 项目描述
	 */
	@TableField("project_desc")
	@ColumnType(length=256)
	@ColumnComment("项目描述")
	private String projectDesc;

	/**
	 * 项目代码
	 */
	@TableField("project_code")
	@ColumnType(length=50)
	@ColumnComment("项目代码")
	private String projectCode;

	/**
	 * 所开通渠道
	 */
	@TableField("document_type")
	@ColumnType(length=255)
	@ColumnComment("所开通渠道")
	private String documentType ;

	/**
     * 支付私钥
     */
	@ColumnType(length=255)
	@ColumnComment("支付私钥")
	@TableField("private_key")
    private String privateKey;

    /**
     * 支付公钥
     */
	@ColumnType(length=255)
	@ColumnComment("支付公钥")
	@TableField("public_key")
    private String publicKey;

    /**
     * 商户支付公钥
     */
	@ColumnType(length=255)
	@ColumnComment("商户支付公钥")
	@TableField("mchnt_public_key")
    private String mchntPublicKey;

    /**
     * 商户支付私钥
     */
	@ColumnType(length=255)
	@ColumnComment("商户支付私钥")
	@TableField("mchnt_private_key")
    private String mchntPrivateKey;

    /**
     * 机构号
     */
	@ColumnType(length=255)
	@ColumnComment("机构号")
	@TableField("ins_cd")
    private String insCd;

    /**
     * 商户号
     */
	@ColumnType(length=255)
	@ColumnComment("商户号")
	@TableField("mchnt_cd")
    private String mchntCd;
}

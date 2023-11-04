package com.alinesno.infra.base.pay.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
/**
 * 功能名：支付应用实体类
 * 数据表：pay_app
 * 表备注：
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@Data
public class PayAppEntity {

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

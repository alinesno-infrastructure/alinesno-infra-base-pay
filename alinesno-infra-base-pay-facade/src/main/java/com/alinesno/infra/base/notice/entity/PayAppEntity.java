package com.alinesno.infra.base.notice.entity;

/**
 * 功能名：支付应用实体类
 * 数据表：pay_app
 * 表备注：
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
public class PayAppEntity {

    /**
     * 支付私钥
     */
    private String privateKey;

    /**
     * 支付公钥
     */
    private String publicKey;

    /**
     * 商户支付公钥
     */
    private String mchntPublicKey;

    /**
     * 商户支付私钥
     */
    private String mchntPrivateKey;

    /**
     * 机构号
     */
    private String insCd;

    /**
     * 商户号
     */
    private String mchntCd;

    public String getPrivateKey() {
        return privateKey;
    }

    public PayAppEntity setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
        return this;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public PayAppEntity setPublicKey(String publicKey) {
        this.publicKey = publicKey;
        return this;
    }

    public String getMchntPublicKey() {
        return mchntPublicKey;
    }

    public PayAppEntity setMchntPublicKey(String mchntPublicKey) {
        this.mchntPublicKey = mchntPublicKey;
        return this;
    }

    public String getMchntPrivateKey() {
        return mchntPrivateKey;
    }

    public PayAppEntity setMchntPrivateKey(String mchntPrivateKey) {
        this.mchntPrivateKey = mchntPrivateKey;
        return this;
    }

    public String getInsCd() {
        return insCd;
    }

    public PayAppEntity setInsCd(String insCd) {
        this.insCd = insCd;
        return this;
    }

    public String getMchntCd() {
        return mchntCd;
    }

    public PayAppEntity setMchntCd(String mchntCd) {
        this.mchntCd = mchntCd;
        return this;
    }

    public PayAppEntity() {
    }

    public PayAppEntity(String privateKey, String publicKey, String mchntPublicKey, String mchntPrivateKey, String insCd, String mchntCd) {
        this.privateKey = privateKey;
        this.publicKey = publicKey;
        this.mchntPublicKey = mchntPublicKey;
        this.mchntPrivateKey = mchntPrivateKey;
        this.insCd = insCd;
        this.mchntCd = mchntCd;
    }
}

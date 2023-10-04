package com.alinesno.infra.base.pay.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 功能名：支付方式实体类
 * 数据表：pay_way
 * 表备注：
 * 
 * 注：
 * 1. 使用MyBatis-Plus注解进行字段映射
 * 2. 表名注解：@TableName("pay_way")
 * 3. 字段注解：@TableField("字段名")
 * 4. 不再需要@ColumnComment和@Excel注解
 * 5. InfraBaseEntity的路径为com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity
 * 6. 字段需要添加中文注释信息
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@TableName("pay_way")
public class PayWayEntity extends InfraBaseEntity {

    /**
     * 支付方式代码，例如：wxpay_jsapi
     */
    @TableField("way_code")
    @Excel(name = "支付方式代码 例如：wxpay_jsapi")
    private String wayCode;

    /**
     * 支付方式名称
     */
    @TableField("way_name")
    @Excel(name = "支付方式名称")
    private String wayName;

    // getter and setter methods
    public String getWayCode() {
        return this.wayCode;
    }

    public PayWayEntity setWayCode(String wayCode) {
        this.wayCode = wayCode;
        return this;
    }

    public String getWayName() {
        return this.wayName;
    }

    public PayWayEntity setWayName(String wayName) {
        this.wayName = wayName;
        return this;
    }
}

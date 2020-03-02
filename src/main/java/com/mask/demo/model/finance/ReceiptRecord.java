package com.mask.demo.model.finance;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author: mac
 * @description: 收款记录表
 * @date: 2020-02-25 16:11
 */
@Data
public class ReceiptRecord implements Serializable {

    /**
     * 收款记录id
     */
    private Integer id;

    /**
     * 关联的应收单id
     */
    private Integer receivablesId;

    /**
     * 关联凭证的id - 例如，销售订单
     */
    private String relationId;

    /**
     * 付款方 - 50字符
     */
    private String payer;

    /**
     * 收款单类型id - 例如，全额收款，部分收款
     */
    private Integer receiptTypeId;

    /**
     * 收款金额
     */
    private BigDecimal receiptAmount;

    /**
     * 收款方式类型id - 例如，支付宝收款
     */
    private Integer receiptAccountTypeId;

    /**
     * 备注 - 200字符；例如，支付宝账号等信息
     */
    private String mark;

    /**
     * 收款日期 - YYYY-MM-dd hh:mm:ss
     */
    private Long receiptDate;

    /**
     * 创建者id
     */
    private String createId;

    /**
     * 创建时间 - 时间戳
     */
    private Long createDate;

    /**
     * 是否删除
     */
    private Boolean isDel;


}

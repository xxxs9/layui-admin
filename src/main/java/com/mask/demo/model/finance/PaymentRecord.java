package com.mask.demo.model.finance;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author: mac
 * @description: 付款记录表
 * @date: 2020-02-25 16:15
 */
@Data
public class PaymentRecord implements Serializable {

    /**
     * 付款单id
     */
    private Integer id;

    /**
     * 关联的应付单id
     */
    private Integer payableId;

    /**
     * 关联凭证的id - 例如，销售订单
     */
    private String relationId;

    /**
     * 付款类型id
     */
    private Integer paymentTypeId;

    /**
     * 收款人
     */
    private String payee;

    /**
     * 付款金额
     */
    private BigDecimal paymentAmount;

    /**
     * 备注 - 200字符
     */
    private String mark;

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

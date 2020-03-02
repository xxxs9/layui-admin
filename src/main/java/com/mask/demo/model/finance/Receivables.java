package com.mask.demo.model.finance;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author: mac
 * @description: 应收款项表
 * @date: 2020-02-25 16:10
 */
@Data
public class Receivables implements Serializable {

    /**
     * 应收款单id
     */
    private Integer id;

    /**
     * 关联凭证的id - 例如，销售订单
     */
    private String relationId;

    /**
     * 应收单类型id - 例如，销售收款
     */
    private Integer receivablesTypeId;

    /**
     * 付款方
     */
    private String payer;

    /**
     * 款项金额
     */
    private BigDecimal receivablesAmount;

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

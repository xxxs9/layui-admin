package com.mask.demo.model.finance;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author: mac
 * @description: 应付款项表
 * @date: 2020-02-25 16:11
 */
@Data
public class Payable implements Serializable {

    /**
     * 应付款单id
     */
    private Integer id;

    /**
     * 关联凭证的id - 例如，销售订单
     */
    private String relationId;

    /**
     * 应付款类型id
     */
    private Integer payableTypeId;

    /**
     * 收款人,50字符
     */
    private String payee;

    /**
     * 应付款金额
     */
    private BigDecimal payableAmount;

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

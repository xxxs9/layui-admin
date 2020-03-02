package com.mask.demo.model.sale;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author: mac
 * @description: TODO
 * @date: 2020-02-25 16:02
 */
@Data
public class SaleOrderDetail implements Serializable {

    /**
     * 订单明细编号，订单编号+排序
     */
    private String saleOrderDetailNumber;

    /**
     * 订单编号
     */
    private String saleOrderNumber;

    /**
     * 货品id
     */
    private Integer productId;

    /**
     * 购买数量
     */
    private Integer number;

    /**
     * 单价
     */
    private BigDecimal unitPrice;

}

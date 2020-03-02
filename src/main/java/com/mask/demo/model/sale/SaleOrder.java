package com.mask.demo.model.sale;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author: mac
 * @description: 销售订单表
 * @date: 2020-02-25 16:01
 */
@Data
public class SaleOrder implements Serializable {

    /**
     * 订单编号，64字符
     */
    private String saleOrderNumber;

    /**
     * 买方,50字符
     */
    private String buyer;

    /**
     * 销售人员id
     */
    private Integer salesmanId;

    /**
     * 总价
     */
    private BigDecimal totalPrice;

    /**
     * 款项,10位
     */
    private BigDecimal orderAmount;

    /**
     * 预交货日期 - YYYY-MM-DD
     */
    private Long expectedDeliveryDate;

    /**
     * 付款状态
     */
    private Integer paymentState;

    /**
     * 出货状态
     */
    private Integer shipmentState;

    /**
     * 订单状态
     */
    private Integer orderState;

    /**
     * 创建人id
     */
    private String createId;

    /**
     * 创建日期 - 时间戳
     */
    private Long createDate;

    /**
     * 是否删除
     */
    private Boolean isDel;
}

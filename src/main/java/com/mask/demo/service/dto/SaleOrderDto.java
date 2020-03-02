package com.mask.demo.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author: mac
 * @description: TODO
 * @date: 2020-02-28 16:34
 */
@Data
public class SaleOrderDto implements Serializable {

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
     * 销售人员名称
     */
    private Integer salesmanName;

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
     * 订单状态描述文本
     */
    private String orderStateStr;

    /**
     * 创建人id
     */
    private String createId;

    /**
     * 创建人名称
     */
    private String createName;

    /**
     * 创建日期 - 时间戳
     */
    private Long createDate;

    /**
     * 已付款金额
     */
    private String payAmount;

    /**
     * 已出货数量
     */
    private String outNumber;

    /**
     * 货品id
     */
    private Integer productId;

    /**
     * 货品名称
     */
    private String productName;

    /**
     * 购买数量
     */
    private Integer number;

    /**
     * 单价
     */
    private BigDecimal unitPrice;
}

package com.mask.demo.service.api.sale;

import com.mask.demo.model.sale.SaleOrder;
import com.mask.demo.service.dto.SaleOrderDto;
import com.mask.demo.service.dto.system.PageRange;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author: mac
 * @description: 销售订单业务逻辑定义
 * @date: 2020-02-26 18:17
 */
public interface SaleOrderService {

    /**
     * 分页加载 - 订单列表
     * @param pageRange
     * @return
     */
    List<SaleOrderDto> listSaleOrder(PageRange pageRange);

    /**
     * 添加销售订单
     * 添加订单的同时，创建应付款单
     * @param saleOrderDto
     * @return
     */
    Boolean addSaleOrder(SaleOrderDto saleOrderDto);

    /**
     * 获取订单，不能获取删除的订单
     * @param orderNumber
     * @return
     */
    SaleOrderDto getSaleOrder(String orderNumber);

    /**
     * 编辑销售订单
     * 仅有订单INIT的状态下才可编辑订单
     * 编辑销售订单的同时，将原有应收款单作废，并且新建一个新的收款单
     * @param saleOrderDto
     * @return
     */
    Boolean updateSaleOrder(SaleOrderDto saleOrderDto);

    /**
     * 删除销售订单
     * 仅有订单在INIT的状态下才可以删除订单
     * 删除订单的同时，删除应收款单
     * 以上均为逻辑删除
     * @param orderNumber
     * @return
     */
    Boolean deleteSaleOrder(String orderNumber);

    /**
     * 订单出货
     * 订单出货的同时，创建出库记录
     * 出库数量不能超出订单数量，仅比较number
     * @return
     */
    Boolean orderShipment();

    /**
     * 订单收款
     * 订单收款的同时，创建相应的收款记录
     * 收款金额不能大于订单金额
     * @return
     */
    Boolean orderReceipt();

    /**
     * 订单退款
     * 订单退款的同时，创建相应的应付单和付款记录
     * 退款金额不大于订单金额
     * @return
     */
    Boolean orderRefund();

    /**
     * 订单完结
     * 订单完结后，订单不可再做除追加以外的任何操作
     * @return
     */
    Boolean orderEnd();

    /**
     * 追加订单
     * 追加订单，同新增订单逻辑
     * @return
     */
    Boolean appendSaleOrder();
}

package com.mask.demo.dao.sale;

import com.mask.demo.model.sale.SaleOrderDetail;

import java.util.List;

public interface SaleOrderDetailMapper {

    /**
     * 根据订单编号，查找订单详情集合
     * @param orderNumber
     * @return
     */
    List<SaleOrderDetail> listBySaleOrderNumber(String orderNumber);

    void insertSaleOrderDetail(SaleOrderDetail saleOrderDetail);
}

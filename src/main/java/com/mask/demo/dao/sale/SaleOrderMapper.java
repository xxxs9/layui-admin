package com.mask.demo.dao.sale;

import com.mask.demo.model.sale.SaleOrder;
import com.mask.demo.service.dto.SaleOrderDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: mac
 * @description: 销售订单表 - 数据库方法定义
 * @date: 2020-02-28 16:42
 */
public interface SaleOrderMapper {

    List<SaleOrderDto> listByQuery(
            @Param("start") int start,
            @Param("end") int end);

    SaleOrderDto loadByOrderNumber(String orderNumber);

    void insertSaleOrder(SaleOrder saleOrder);

    void updateSaleOrder(SaleOrder saleOrder);

    void deleteSaleOrder(String orderNumber);
}

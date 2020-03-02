package com.mask.demo.controller.sale;

import com.mask.demo.frame.beans.response.IResult;
import com.mask.demo.frame.beans.response.ResultBean;
import com.mask.demo.model.sale.SaleOrder;
import com.mask.demo.service.api.sale.SaleOrderService;
import com.mask.demo.service.dto.SaleOrderDto;
import com.mask.demo.service.dto.system.PageRange;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: mac
 * @description: 销售订单模块
 * @date: 2020-02-26 18:14
 */
@Slf4j
@RestController
@RequestMapping("order")
public class SaleOrderController {

    @Autowired
    private SaleOrderService service;

    /**
     * 分页加载 - 销售订单列表
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("list")
    public IResult listSaleOrder(String page, String limit){
        PageRange pageRange = new PageRange(page, limit);
        return new ResultBean<>(service.listSaleOrder(pageRange));
    }

    /**
     * 添加销售订单 - 订单初始化INIT状态
     * 必填项：创建日期、买方、销售人员、数量、单价、总价、款项、预交货日期
     * 该系统暂时只有一种产品，所以无需传递产品id，由service自己设置
     * @param saleOrder
     * @return
     */
    public IResult addSaleOrder(@RequestBody SaleOrderDto saleOrder){
        return new ResultBean<>(service.addSaleOrder(saleOrder));
    }

    /**
     * 根据订单编号，获取订单
     * @param orderNumber
     * @return
     */
    public IResult getSaleOrder(String orderNumber){
        return new ResultBean<>(service.getSaleOrder(orderNumber));
    }

    /**
     * 编辑订单 - 订单INIT时可编辑
     * 必填项：买方、销售人员、数量、单价、总价、款项、预交货日期
     * @param saleOrder
     * @return
     */
    public IResult updateSaleOrder(@RequestBody SaleOrderDto saleOrder){
        return new ResultBean<>();
    }

    /**
     * 删除订单 - 订单进行中时(LOAD)，不可删除
     * @param orderNumber
     * @return
     */
    public IResult deleteSaleOrder(String orderNumber){
        return new ResultBean<>(service.deleteSaleOrder(orderNumber));
    }

    /**
     * 订单出货 - 订单变成进行中LOAD状态
     * 必填项：数量、发货方式、箱、发货日期（年月日）
     * 选填：备注
     * @return
     */
    public IResult orderShipment(){
        return new ResultBean<>();
    }

    /**
     * 订单收款 - 订单变成进行中LOAD状态
     * 必填项：收款日期（要到时分）、账号（枚举）、金额
     * 选填：备注
     * @return
     */
    public IResult orderReceipt(){
        return new ResultBean<>();
    }

    /**
     * 订单退款 - 订单变成进行中LOAD状态
     * 必填项：收款人、应付款金额
     * 选填：备注
     * @return
     */
    public IResult orderRefund(){
        return new ResultBean<>();
    }

    /**
     * 订单完结 - 订单变成进行中END状态
     * 注意：在款项没有全部支付完毕或者货品没有全部发出时，也可完结
     * @return
     */
    public IResult orderEnd(){
        return new ResultBean<>();
    }

    /**
     * 追加订单 - 订单任何时刻都可追加
     * 在原订单信息上，新增一个新的订单
     * 必填项：数量、单价、总价、款项、预交货日期
     * @return
     */
    public IResult appendSaleOrder(){
        return new ResultBean<>();
    }
}

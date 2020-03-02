package com.mask.demo.service.impl.sale;

import com.mask.demo.dao.sale.SaleOrderDetailMapper;
import com.mask.demo.dao.sale.SaleOrderMapper;
import com.mask.demo.frame.utils.CheckUtil;
import com.mask.demo.model.produce.extend.ProductEnum;
import com.mask.demo.model.sale.SaleOrder;
import com.mask.demo.model.sale.SaleOrderDetail;
import com.mask.demo.model.sale.extend.OrderStateEnum;
import com.mask.demo.service.api.finance.FinanceExternalService;
import com.mask.demo.service.api.sale.SaleOrderService;
import com.mask.demo.service.dto.SaleOrderDto;
import com.mask.demo.service.dto.system.PageRange;
import com.mask.demo.utils.SessionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: mac
 * @description: 销售订单业务逻辑实现
 * @date: 2020-02-26 18:16
 */
@Slf4j
@Service
public class SaleOrderServiceImpl implements SaleOrderService {

    @Autowired
    private SaleOrderMapper saleOrderMapper;

    @Autowired
    private SaleOrderDetailMapper saleOrderDetailMapper;

    @Autowired
    private FinanceExternalService financeExternalService;

    /**
     * 分页加载 - 订单列表
     * @param pageRange
     * @return
     */
    @Override
    public List<SaleOrderDto> listSaleOrder(PageRange pageRange) {
        // TODO 需要加入查询条件：日期，订单状态，销售人员
        List<SaleOrderDto> dtoList = saleOrderMapper.listByQuery(pageRange.getStart(), pageRange.getEnd());
        for (SaleOrderDto dto : dtoList) {
            packDetail(dto);
            packEnum(dto);
        }
        return dtoList;
    }

    /**
     * 添加销售订单
     * 添加订单的同时，创建应付款单
     * @param saleOrderDto
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean addSaleOrder(SaleOrderDto saleOrderDto) {
        // 插入订单
        SaleOrder saleOrder = new SaleOrder();
        BeanUtils.copyProperties(saleOrderDto, saleOrder);
        // TODO 等待创建订单编号自动生成工具类，编号：D + 年月日信息+2~4位混淆码即可(可用当日分钟数）
        saleOrder.setSaleOrderNumber("test");
        saleOrder.setCreateDate(System.currentTimeMillis());
        saleOrder.setCreateId(SessionUtil.getSession().getAttribute("sysUserId").toString());
        saleOrder.setIsDel(false);
        saleOrderMapper.insertSaleOrder(saleOrder);
        // 插入订单明细
        SaleOrderDetail saleOrderDetail = new SaleOrderDetail();
        BeanUtils.copyProperties(saleOrderDto, saleOrderDetail);
        saleOrderDetail.setSaleOrderNumber("test");
        saleOrderDetail.setSaleOrderDetailNumber("test-detail");
        saleOrderDetailMapper.insertSaleOrderDetail(saleOrderDetail);
        // 生成应收单
        financeExternalService.addReceivables();
        return true;
    }

    /**
     * 获取订单，不能获取删除的订单
     * @param orderNumber
     * @return
     */
    @Override
    public SaleOrderDto getSaleOrder(String orderNumber) {
        SaleOrderDto dto = saleOrderMapper.loadByOrderNumber(orderNumber);
        if (dto != null) {
            packDetail(dto);
            packEnum(dto);
        }
        return dto;
    }

    /**
     * 编辑销售订单
     * 仅有订单INIT的状态下才可编辑订单
     * 编辑销售订单的同时，将原有应收款单作废，并且新建一个新的收款单
     * @param saleOrderDto
     * @return
     */
    @Override
    public Boolean updateSaleOrder(SaleOrderDto saleOrderDto) {
        // TODO 延后开发
        return null;
    }

    /**
     * 删除销售订单
     * 仅有订单在INIT的状态下才可以删除订单
     * 删除订单的同时，删除应收款单
     * 以上均为逻辑删除
     * @param orderNumber
     * @return
     */
    @Override
    public Boolean deleteSaleOrder(String orderNumber) {
        // 校验订单状态不属于，进行中状态LOAD
        SaleOrderDto dto = saleOrderMapper.loadByOrderNumber(orderNumber);
        CheckUtil.check(OrderStateEnum.LOAD.getOrderStateId().equals(dto.getOrderState()),
                "不可删除进行中的订单，请先完结订单");
        saleOrderMapper.deleteSaleOrder(orderNumber);
        return true;
    }

    @Override
    public Boolean orderShipment() {
        // TODO 等待开发
        return null;
    }

    @Override
    public Boolean orderReceipt() {
        // TODO 等待开发
        return null;
    }

    @Override
    public Boolean orderRefund() {
        // TODO 等待开发
        return null;
    }

    @Override
    public Boolean orderEnd() {
        // TODO 等待开发
        return null;
    }

    @Override
    public Boolean appendSaleOrder() {
        // TODO 等待开发
        return null;
    }


    /**
     * 状态订单明细
     * @param dto
     */
    private void packDetail(SaleOrderDto dto){
        // 查找订单明细
        List<SaleOrderDetail> sodList = saleOrderDetailMapper.listBySaleOrderNumber(dto.getOutNumber());
        if (sodList != null && sodList.size() > 0) {
            dto.setProductId(sodList.get(0).getProductId());
            dto.setNumber(sodList.get(0).getNumber());
            dto.setUnitPrice(sodList.get(0).getUnitPrice());
            dto.setProductName(ProductEnum.getProductName(dto.getProductId()));
        }
    }

    /**
     * 状态枚举类型信息
     * @param dto
     */
    private void packEnum(SaleOrderDto dto){
        dto.getOrderState();
        dto.getPaymentState();
        dto.getShipmentState();
    }
}

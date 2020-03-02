package com.mask.demo.controller.depository;

import com.mask.demo.frame.beans.response.IResult;
import com.mask.demo.frame.beans.response.ResultBean;
import com.mask.demo.service.api.depository.ShipmentService;
import com.mask.demo.service.dto.system.PageRange;
import com.mask.demo.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: mac
 * @description: 仓库管理 - 出库记录
 * @date: 2020-02-27 11:24
 */
@Slf4j
@RestController
@RequestMapping("shipment")
public class ShipmentController {

    @Autowired
    private ShipmentService service;


    /**
     * 分页加载 - 出库记录
     * @param page
     * @param limit
     * @param orderNumber   查询条件 - 订单编号
     * @param date          查询条件 - 记录日期
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.POST)
    public IResult listShipmentRecord(String page, String limit, String orderNumber, String date){
        PageRange pageRange = new PageRange(page, limit);
        return new ResultBean<>(service.listShipmentRecord(pageRange, orderNumber, DateUtil.str2Long(date)));
    }
}

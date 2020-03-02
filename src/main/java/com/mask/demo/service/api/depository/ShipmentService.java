package com.mask.demo.service.api.depository;

import com.mask.demo.service.dto.depository.ShipmentDto;
import com.mask.demo.service.dto.system.PageRange;

import java.util.List;

/**
 * @author: mac
 * @description: 出库记录业务定义层
 * @date: 2020-02-27 11:29
 */
public interface ShipmentService {

    /**
     * 分页加载出库记录
     * @param pageRange
     * @param orderNumber
     * @param date
     * @return
     */
    List<ShipmentDto> listShipmentRecord(PageRange pageRange, String orderNumber, Long date);
}

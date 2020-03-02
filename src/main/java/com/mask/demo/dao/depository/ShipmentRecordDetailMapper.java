package com.mask.demo.dao.depository;

import com.mask.demo.model.depository.ShipmentRecordDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: mac
 * @description: 出库明细表 - 数据库操作定义
 * @date: 2020-02-27 11:39
 */
public interface ShipmentRecordDetailMapper {

    /**
     * 根据出库记录id获取出库明细集合
     * @param shipmentRecordId
     * @return
     */
    List<ShipmentRecordDetail> listByShipmentRecordId(
            @Param("shipmentRecordId") Integer shipmentRecordId);
}

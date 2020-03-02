package com.mask.demo.model.depository;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: mac
 * @description: 出库记录明细表
 * @date: 2020-02-25 17:31
 */
@Data
public class ShipmentRecordDetail implements Serializable {

    /**
     * 出库记录明细id
     */
    private Integer id;

    /**
     * 出库记录id
     */
    private Integer shipmentRecordId;

    /**
     * 货品id
     */
    private Integer productId;

    /**
     * 出库数量
     */
    private Integer number;

    /**
     * 装箱数量
     */
    private Integer cartonBoxNumber;
}

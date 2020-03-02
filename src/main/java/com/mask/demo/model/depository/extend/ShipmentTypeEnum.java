package com.mask.demo.model.depository.extend;

import com.mask.demo.model.finance.extend.ReceivablesTypeEnum;

/**
 * @author: mac
 * @description: 出库类型枚举类 - 后期可转出库类型表
 * @date: 2020-02-25 16:32
 */
public enum ShipmentTypeEnum {

    /**
     * 销售出库
     */
    SALE_OUT(1,"销售出库");

    /**
     * 出库类型id
     */
    private Integer shipmentTypeId;

    /**
     * 出库类型名称
     */
    private String shipmentTypeName;

    ShipmentTypeEnum(Integer shipmentTypeId, String shipmentTypeName){
        this.shipmentTypeId = shipmentTypeId;
        this.shipmentTypeName = shipmentTypeName;
    }

    /**
     * 通过id，获取名称
     * @param shipmentTypeId
     * @return
     */
    public static String getShipmentTypeName(Integer shipmentTypeId) {
        if (shipmentTypeId != null) {
            ShipmentTypeEnum[] shipmentTypeEnums = values();
            for (ShipmentTypeEnum shipmentTypeEnum : shipmentTypeEnums) {
                if (shipmentTypeEnum.getShipmentTypeId().equals(shipmentTypeId)) {
                    return shipmentTypeEnum.getShipmentTypeName();
                }
            }
        }
        return null;
    }

    public Integer getShipmentTypeId() {
        return this.shipmentTypeId;
    }

    public String getShipmentTypeName(){
        return this.shipmentTypeName;
    }
}

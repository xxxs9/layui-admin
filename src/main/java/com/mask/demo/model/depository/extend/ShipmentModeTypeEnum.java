package com.mask.demo.model.depository.extend;

import com.mask.demo.model.finance.extend.ReceivablesTypeEnum;

/**
 * @author: mac
 * @description: 出库模式类型枚举类 - 后期可转出库模式表
 * @date: 2020-02-25 16:35
 */
public enum ShipmentModeTypeEnum {

    /**
     * 自提
     */
    SELF_TAKE(1,"自提"),
    /**
     * 快递
     */
    FAST_MAIL(2,"快递"),
    /**
     * 物流
     */
    LOGISTICS(3,"物流");

    /**
     * 出库模式id
     */
    private Integer shipmentModeTypeId;

    /**
     * 出库模式名称
     */
    private String shipmentModeTypeName;

    ShipmentModeTypeEnum(Integer shipmentModeTypeId, String shipmentModeTypeName){
        this.shipmentModeTypeId = shipmentModeTypeId;
        this.shipmentModeTypeName = shipmentModeTypeName;
    }

    /**
     * 通过id，获取名称
     * @param shipmentModeTypeId
     * @return
     */
    public static String getShipmentModeTypeName(Integer shipmentModeTypeId) {
        if (shipmentModeTypeId != null) {
            ShipmentModeTypeEnum[] shipmentModeTypeEnums = values();
            for (ShipmentModeTypeEnum shipmentModeTypeEnum : shipmentModeTypeEnums) {
                if (shipmentModeTypeEnum.getShipmentModeTypeId().equals(shipmentModeTypeId)) {
                    return shipmentModeTypeEnum.getShipmentModeTypeName();
                }
            }
        }
        return null;
    }

    public Integer getShipmentModeTypeId() {
        return this.shipmentModeTypeId;
    }

    public String getShipmentModeTypeName(){
        return this.shipmentModeTypeName;
    }
}

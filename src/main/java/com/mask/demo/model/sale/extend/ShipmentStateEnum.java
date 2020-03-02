package com.mask.demo.model.sale.extend;

/**
 * @author: mac
 * @description: 订单出货状态枚举
 * @date: 2020-02-27 14:48
 */
public enum ShipmentStateEnum {

    /**
     * 待发货
     */
    WARN(1,"待发货"),
    /**
     * 部分发货
     */
    PART(2,"部分发货"),
    /**
     * 全额发货
     */
    FULL(3,"全部发货");

    /**
     * 订单出货状态id
     */
    private Integer shipmentStateId;

    /**
     * 订单出货状态名称
     */
    private String shipmentStateName;

    ShipmentStateEnum(Integer shipmentStateId, String shipmentStateName){
        this.shipmentStateId = shipmentStateId;
        this.shipmentStateName = shipmentStateName;
    }

    /**
     * 通过id，获取名称
     * @param shipmentStateId
     * @return
     */
    public static String getShipmentStateName(Integer shipmentStateId) {
        if (shipmentStateId != null) {
            ShipmentStateEnum[] shipmentStateEnums = values();
            for (ShipmentStateEnum shipmentStateEnum : shipmentStateEnums) {
                if (shipmentStateEnum.getShipmentStateId().equals(shipmentStateId)) {
                    return shipmentStateEnum.getShipmentStateName();
                }
            }
        }
        return null;
    }

    public Integer getShipmentStateId() {
        return this.shipmentStateId;
    }

    public String getShipmentStateName(){
        return this.shipmentStateName;
    }


}

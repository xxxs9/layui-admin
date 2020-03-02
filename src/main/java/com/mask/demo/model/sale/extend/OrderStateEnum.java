package com.mask.demo.model.sale.extend;

/**
 * @author: mac
 * @description: 订单状态枚举
 * @date: 2020-02-27 14:47
 */
public enum  OrderStateEnum {

    /**
     * 订单启用
     */
    INIT(1,"初始化"),
    /**
     * 订单启用
     */
    LOAD(2,"进行中"),
    /**
     * 订单完结
     */
    END(3,"完结");

    /**
     * 订单状态id
     */
    private Integer orderStateId;

    /**
     * 订单状态名称
     */
    private String orderStateName;

    OrderStateEnum(Integer orderStateId, String orderStateName){
        this.orderStateId = orderStateId;
        this.orderStateName = orderStateName;
    }

    /**
     * 通过id，获取名称
     * @param orderStateId
     * @return
     */
    public static String getOrderStateName(Integer orderStateId) {
        if (orderStateId != null) {
            OrderStateEnum[] orderStateEnums = values();
            for (OrderStateEnum orderStateEnum : orderStateEnums) {
                if (orderStateEnum.getOrderStateId().equals(orderStateId)) {
                    return orderStateEnum.getOrderStateName();
                }
            }
        }
        return null;
    }

    public Integer getOrderStateId() {
        return this.orderStateId;
    }

    public String getOrderStateName(){
        return this.orderStateName;
    }
}

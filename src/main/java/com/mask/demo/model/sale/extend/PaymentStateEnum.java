package com.mask.demo.model.sale.extend;

/**
 * @author: mac
 * @description: 订单付款状态枚举
 * @date: 2020-02-27 14:48
 */
public enum PaymentStateEnum {

    /**
     * 待付款
     */
    WARN(1,"待付款"),
    /**
     * 部分付款
     */
    PART(2,"部分付款"),
    /**
     * 全额付款
     */
    FULL(3,"全额付款");

    /**
     * 订单付款状态id
     */
    private Integer paymentStateId;

    /**
     * 订单付款状态名称
     */
    private String paymentStateName;

    PaymentStateEnum(Integer paymentStateId, String paymentStateName){
        this.paymentStateId = paymentStateId;
        this.paymentStateName = paymentStateName;
    }

    /**
     * 通过id，获取名称
     * @param paymentStateId
     * @return
     */
    public static String getPaymentStateName(Integer paymentStateId) {
        if (paymentStateId != null) {
            PaymentStateEnum[] paymentStateEnums = values();
            for (PaymentStateEnum paymentStateEnum : paymentStateEnums) {
                if (paymentStateEnum.getPaymentStateId().equals(paymentStateId)) {
                    return paymentStateEnum.getPaymentStateName();
                }
            }
        }
        return null;
    }

    public Integer getPaymentStateId() {
        return this.paymentStateId;
    }

    public String getPaymentStateName(){
        return this.paymentStateName;
    }
}

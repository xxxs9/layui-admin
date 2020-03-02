package com.mask.demo.model.finance.extend;

/**
 * @author: mac
 * @description: 付款类型枚举类 - 后期可转付款类型表
 * @date: 2020-02-25 16:40
 */
public enum PaymentTypeEnum {

    /**
     * 全额退款
     */
    WHOLE_PAYMENT(1,"全额退款");

    /**
     * 付款项类型id
     */
    private Integer paymentTypeId;

    /**
     * 付款项类型名称
     */
    private String paymentTypeName;

    PaymentTypeEnum(Integer paymentTypeId, String paymentTypeName){
        this.paymentTypeId = paymentTypeId;
        this.paymentTypeName = paymentTypeName;
    }

    /**
     * 通过id，获取名称
     * @param paymentTypeId
     * @return
     */
    public static String getPayableTypeName(Integer paymentTypeId) {
        PaymentTypeEnum[] paymentTypeEnums = values();
        for (PaymentTypeEnum paymentTypeEnum : paymentTypeEnums) {
            if (paymentTypeEnum.getPaymentTypeId().equals(paymentTypeId)) {
                return paymentTypeEnum.getPaymentTypeName();
            }
        }
        return null;
    }

    public Integer getPaymentTypeId() {
        return this.paymentTypeId;
    }

    public String getPaymentTypeName(){
        return this.paymentTypeName;
    }
}

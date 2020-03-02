package com.mask.demo.model.finance.extend;

import com.mask.demo.model.produce.extend.ProductEnum;

/**
 * @author: mac
 * @description: 应付款项类型枚举类 - 后期可转应付款项类型表
 * @date: 2020-02-25 16:38
 */
public enum PayableTypeEnum {

    /**
     * 销售退款
     */
    SALE_PAYABLE(1,"销售退款");

    /**
     * 应付款项类型id
     */
    private Integer payableTypeId;

    /**
     * 应付款项类型名称
     */
    private String payableTypeName;

    PayableTypeEnum(Integer payableTypeId, String payableTypeName){
        this.payableTypeId = payableTypeId;
        this.payableTypeName = payableTypeName;
    }

    /**
     * 通过id，获取名称
     * @param payableTypeId
     * @return
     */
    public static String getPayableTypeName(Integer payableTypeId) {
        PayableTypeEnum[] payableTypeEnums = values();
        for (PayableTypeEnum payableTypeEnum : payableTypeEnums) {
            if (payableTypeEnum.getPayableTypeId().equals(payableTypeId)) {
                return payableTypeEnum.getPayableTypeName();
            }
        }
        return null;
    }

    public Integer getPayableTypeId() {
        return this.payableTypeId;
    }

    public String getPayableTypeName(){
        return this.payableTypeName;
    }
}

package com.mask.demo.model.finance.extend;

/**
 * @author: mac
 * @description: 收款类型枚举类 - 后期可转收款类型表
 * @date: 2020-02-25 16:41
 */
public enum ReceiptTypeEnum {

    /**
     * 全额收款
     */
    WHOLE_RECEIPT(1,"全额收款"),
    /**
     * 部分收款
     */
    PART_RECEIPT(2,"部分收款");

    /**
     * 收款类型id
     */
    private Integer receiptTypeId;

    /**
     * 收款类型名称
     */
    private String receiptTypeName;

    ReceiptTypeEnum(Integer receiptTypeId, String receiptTypeName){
        this.receiptTypeId = receiptTypeId;
        this.receiptTypeName = receiptTypeName;
    }

    /**
     * 通过id，获取名称
     * @param receiptTypeId
     * @return
     */
    public static String getReceiptTypeName(Integer receiptTypeId) {
        ReceiptTypeEnum[] receiptTypeEnums = values();
        for (ReceiptTypeEnum receiptTypeEnum : receiptTypeEnums) {
            if (receiptTypeEnum.getReceiptTypeId().equals(receiptTypeId)) {
                return receiptTypeEnum.getReceiptTypeName();
            }
        }
        return null;
    }

    public Integer getReceiptTypeId() {
        return this.receiptTypeId;
    }

    public String getReceiptTypeName(){
        return this.receiptTypeName;
    }
}

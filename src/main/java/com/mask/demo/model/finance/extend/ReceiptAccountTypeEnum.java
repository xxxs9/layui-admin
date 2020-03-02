package com.mask.demo.model.finance.extend;

/**
 * @author: mac
 * @description: 收款账号类型枚举类 - 后期可转收款账号类型表
 * @date: 2020-02-25 16:37
 */
public enum ReceiptAccountTypeEnum {

    /**
     * 转账
     */
    TRANSFER_ACCOUNT(1,"转账"),
    /**
     * 微信收款
     */
    WX_PAY(1,"微信收款"),
    /**
     * 支付宝收款
     */
    ALI_PAY(1,"支付宝");

    /**
     * 收款账号类型id
     */
    private Integer receiptAccountTypeId;

    /**
     * 收款账号类型名称
     */
    private String receiptAccountTypeName;

    ReceiptAccountTypeEnum(Integer receiptAccountTypeId, String receiptAccountTypeName){
        this.receiptAccountTypeId = receiptAccountTypeId;
        this.receiptAccountTypeName = receiptAccountTypeName;
    }

    /**
     * 通过id，获取名称
     * @param receiptAccountTypeId
     * @return
     */
    public static String getReceiptAccountTypeName(Integer receiptAccountTypeId) {
        ReceiptAccountTypeEnum[] receiptAccountTypeEnums = values();
        for (ReceiptAccountTypeEnum receiptAccountTypeEnum : receiptAccountTypeEnums) {
            if (receiptAccountTypeEnum.getReceiptAccountTypeId().equals(receiptAccountTypeId)) {
                return receiptAccountTypeEnum.getReceiptAccountTypeName();
            }
        }
        return null;
    }

    public Integer getReceiptAccountTypeId() {
        return this.receiptAccountTypeId;
    }

    public String getReceiptAccountTypeName(){
        return this.receiptAccountTypeName;
    }
}

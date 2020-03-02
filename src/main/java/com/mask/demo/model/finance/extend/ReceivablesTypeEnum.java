package com.mask.demo.model.finance.extend;

/**
 * @author: mac
 * @description: 应收单类型枚举类 - 后期可转应收款项类型表
 * @date: 2020-02-25 16:40
 */
public enum ReceivablesTypeEnum {

    /**
     * 销售收款
     */
    SALE(1,"销售收款");

    /**
     * 应收单类型id
     */
    private Integer receivablesTypeId;

    /**
     * 应收单类型名称
     */
    private String receivablesTypeName;

    ReceivablesTypeEnum(Integer receivablesTypeId, String receivablesTypeName){
        this.receivablesTypeId = receivablesTypeId;
        this.receivablesTypeName = receivablesTypeName;
    }

    /**
     * 通过id，获取名称
     * @param receivablesTypeId
     * @return
     */
    public static String getReceiptTypeName(Integer receivablesTypeId) {
        ReceivablesTypeEnum[] receivablesTypeEnums = values();
        for (ReceivablesTypeEnum receivablesTypeEnum : receivablesTypeEnums) {
            if (receivablesTypeEnum.getReceivablesTypeId().equals(receivablesTypeId)) {
                return receivablesTypeEnum.getReceiptTypeName();
            }
        }
        return null;
    }

    public Integer getReceivablesTypeId() {
        return this.receivablesTypeId;
    }

    public String getReceiptTypeName(){
        return this.receivablesTypeName;
    }
}

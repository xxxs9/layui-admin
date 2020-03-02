package com.mask.demo.model.produce.extend;

/**
 * @author: mac
 * @description: 货品枚举类型 - 后期可变货品表
 * @date: 2020-02-25 16:52
 */
public enum ProductEnum {

    /**
     * 一次性防护口罩
     */
    FANG_PU_MASK(1,"防护口罩");

    /**
     * 货品id
     */
    private Integer productId;

    /**
     * 货品名称
     */
    private String productName;

    ProductEnum(Integer productId, String productName){
        this.productId = productId;
        this.productName = productName;
    }

    /**
     * 通过id，获取名称
     * @param productId
     * @return
     */
    public static String getProductName(Integer productId) {
        if (productId != null) {
            ProductEnum[] productEnums = values();
            for (ProductEnum productEnum : productEnums) {
                if (productEnum.getProductId().equals(productId)) {
                    return productEnum.getProductName();
                }
            }
        }
        return null;
    }

    public Integer getProductId() {
        return this.productId;
    }

    public String getProductName(){
        return this.productName;
    }
}

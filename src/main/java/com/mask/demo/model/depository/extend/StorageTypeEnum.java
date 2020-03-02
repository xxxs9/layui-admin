package com.mask.demo.model.depository.extend;

/**
 * @author: mac
 * @description: 入库类型枚举类 - 后期可转入库类型表
 * @date: 2020-02-25 16:31
 */
public enum StorageTypeEnum {

    /**
     * 生产入库
     */
    PRODUCE_INTO(1,"生产入库");

    /**
     * 入库类型id
     */
    private Integer storageTypeId;

    /**
     * 入库类型名称
     */
    private String storageTypeName;

    StorageTypeEnum(Integer storageTypeId, String storageTypeName){
        this.storageTypeId = storageTypeId;
        this.storageTypeName = storageTypeName;
    }

    /**
     * 通过id，获取名称
     * @param storageTypeId
     * @return
     */
    public static String getStorageTypeName(Integer storageTypeId) {
        if (storageTypeId != null) {
            StorageTypeEnum[] storageTypeEnums = values();
            for (StorageTypeEnum storageTypeEnum : storageTypeEnums) {
                if (storageTypeEnum.getStorageTypeId().equals(storageTypeId)) {
                    return storageTypeEnum.getStorageTypeName();
                }
            }
        }
        return null;
    }

    public Integer getStorageTypeId() {
        return this.storageTypeId;
    }

    public String getStorageTypeName(){
        return this.storageTypeName;
    }
}

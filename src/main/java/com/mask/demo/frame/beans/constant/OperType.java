package com.mask.demo.frame.beans.constant;

/**
 * @author: mac
 * @description: 操作类型枚举
 * @date: 2020-02-25 16:19
 */
public enum OperType {
    /**
     * 查询，一般不用，仅作为默认项
     */
    Query("sel"),
    /**
     * 新增操作
     */
    ADD("add"),
    /**
     * 删除操作
     */
    DELETE("del"),
    /**
     * 更新操作
     */
    UPDATE("upd"),
    /**
     * 上传文件
     */
    UPLOAD("uploadFile"),
    /**
     * 下载文件
     */
    DOWNLOAD("downloadFile");

    /**
     * 枚举值
     */
    private String value;

    private OperType(String type){
        this.value = type;
    }

    public String getValue(){
        return this.value;
    }
}

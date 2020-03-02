package com.mask.demo.model.depository;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: mac
 * @description: 入库记录表
 * @date: 2020-02-25 16:06
 */
@Data
public class StorageRecord implements Serializable {

    /**
     * 入库记录id
     */
    private Integer id;

    /**
     * 入库类型id
     */
    private Integer storageTypeId;

    /**
     * 关联凭证的id - 例如，生产记录
     */
    private String relationId;

    /**
     * 备注 - 不超过200个字符
     */
    private String mark;

    /**
     * 创建者id
     */
    private String createId;

    /**
     * 创建时间 - 时间戳
     */
    private Long createDate;

    /**
     * 是否删除
     */
    private Boolean isDel;
}

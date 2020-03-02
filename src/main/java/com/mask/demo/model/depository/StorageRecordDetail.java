package com.mask.demo.model.depository;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: mac
 * @description: 入库记录明细表
 * @date: 2020-02-25 17:30
 */
@Data
public class StorageRecordDetail implements Serializable {

    /**
     * 入库记录明细id
     */
    private Integer id;

    /**
     * 入库记录id
     */
    private Integer storageRecordId;

    /**
     * 货品id
     */
    private Integer productId;

    /**
     * 入库数量
     */
    private Integer number;
}

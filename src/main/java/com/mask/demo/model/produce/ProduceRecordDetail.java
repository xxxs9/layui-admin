package com.mask.demo.model.produce;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: mac
 * @description: 生产记录明细表
 * @date: 2020-02-25 17:05
 */
@Data
public class ProduceRecordDetail implements Serializable {

    /**
     * 生产记录明细id
     */
    private Integer id;

    /**
     * 生产记录id
     */
    private Integer produceRecordId;

    /**
     * 货品id
     */
    private Integer productId;

    /**
     * 生产数量
     */
    private Integer number;

}

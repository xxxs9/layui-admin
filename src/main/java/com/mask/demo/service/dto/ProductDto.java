package com.mask.demo.service.dto;

import com.mask.demo.model.produce.ProduceRecord;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: mac
 * @description: 生产日报返回实体
 * @date: 2020-02-26 13:51
 */
@Data
public class ProductDto implements Serializable {

    /**
     * 生产记录id
     */
    private Integer id;

    /**
     * 货品id
     */
    private Integer productId;

    /**
     * 货品名称
     */
    private String productName;

    /**
     * 生产数量
     */
    private Integer number;

    /**
     * 创建人名称
     */
    private String createName;

    /**
     * 创建日期
     */
    private String createDate;

    /**
     * 备注 - 不超过200个字符
     */
    private String mark;
}

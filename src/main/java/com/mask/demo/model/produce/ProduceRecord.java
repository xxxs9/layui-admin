package com.mask.demo.model.produce;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: mac
 * @description: 生产记录表
 * @date: 2020-02-25 15:59
 */
@Data
public class ProduceRecord implements Serializable {

    /**
     * 生产记录id
     */
    private Integer id;

    /**
     * 创建人id
     */
    private String createId;

    /**
     * 创建日期 - 时间戳
     */
    private Long createDate;

    /**
     * 备注 - 不超过200个字符
     */
    private String mark;

    /**
     * 是否删除
     */
    private Boolean isDel;
}

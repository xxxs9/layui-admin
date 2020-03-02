package com.mask.demo.service.dto.depository;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: mac
 * @description: 仓库管理 - 入库记录页面实体
 * @date: 2020-02-27 14:02
 */
@Data
public class StorageDto implements Serializable {

    /**
     * 入库记录id
     */
    private Integer id;

    /**
     * 入库类型id
     */
    private Integer storageTypeId;

    /**
     * 入库类型名称
     */
    private String storageTypeName;

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
     * 创建者id
     */
    private String createName;

    /**
     * 创建时间 - 时间戳
     */
    private Long createDate;

    /**
     * 货品id
     */
    private Integer productId;

    /**
     * 货品名称
     */
    private String productName;

    /**
     * 入库数量
     */
    private Integer number;
}

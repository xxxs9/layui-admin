package com.mask.demo.service.dto.depository;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: mac
 * @description: 出库记录前端显示实体
 * @date: 2020-02-27 11:30
 */
@Data
public class ShipmentDto implements Serializable {

    /**
     * 出库记录id
     */
    private Integer id;

    /**
     * 出库类型id
     */
    private Integer shipmentTypeId;

    /**
     * 出库模式id
     */
    private Integer shipmentModeTypeId;

    /**
     * 出库类型名称
     */
    private String shipmentTypeName;

    /**
     * 出库模式名称
     */
    private String shipmentModeTypeName;

    /**
     * 关联凭证的id - 例如，销售订单
     */
    private String relationId;

    /**
     * 备注(例如快递单号等信息) - 不超过200个字符
     */
    private String mark;

    /**
     * 出库日期 - YYYY-MM-DD
     */
    private String shipmentDate;

    /**
     * 创建者id
     */
    private String createId;

    /**
     * 创建者名称
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
     * 出库数量
     */
    private Integer number;

    /**
     * 装箱数量
     */
    private Integer cartonBoxNumber;

}

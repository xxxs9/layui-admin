package com.mask.demo.model.depository;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: mac
 * @description: 出库记录表
 * @date: 2020-02-25 16:08
 */
@Data
public class ShipmentRecord implements Serializable {

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
    private Long shipmentDate;

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

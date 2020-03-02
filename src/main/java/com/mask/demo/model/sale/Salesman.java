package com.mask.demo.model.sale;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: mac
 * @description: 销售人员表
 * @date: 2020-02-25 16:00
 */
@Data
public class Salesman implements Serializable {

    /**
     * 销售人员id
     */
    private Integer id;

    /**
     * 销售人员名称 - 唯一约束，20字符
     */
    private String salesmanName;

    /**
     * 销售人员电话 - 15字符
     */
    private String phone;

    /**
     * 销售人员账号 - 50字符
     */
    private String account;

    /**
     * 创建人id
     */
    private String createId;

    /**
     * 创建日期 - 时间戳
     */
    private Long createDate;

    /**
     * 是否删除
     */
    private Boolean isDel;
}

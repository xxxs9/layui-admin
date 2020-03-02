package com.mask.demo.service.api.sale;

import com.mask.demo.model.sale.Salesman;
import com.mask.demo.service.dto.system.PageRange;

import java.util.List;

/**
 * @author: mac
 * @description: 销售人员业务逻辑定义
 * @date: 2020-02-26 17:06
 */
public interface SalesmanService {

    /**
     * 获取销售人员列表
     * @param pageRange
     * @param name
     * @return
     */
    List<Salesman> listSalesman(PageRange pageRange, String name);

    /**
     * 新增销售人员
     * @param salesman
     * @return
     */
    Boolean addSalesman(Salesman salesman);

    /**
     * 编辑销售人员
     * @param salesman
     * @return
     */
    Boolean updateSalesman(Salesman salesman);

    /**
     * 删除人员 - 逻辑删除，数据库保留，前端不显示
     * @param id
     * @return
     */
    Boolean deleteSalesman(Integer id);

    /**
     * 通过id获取销售人员信息
     * @param id
     * @return
     */
    Salesman getSalesman(Integer id);
}

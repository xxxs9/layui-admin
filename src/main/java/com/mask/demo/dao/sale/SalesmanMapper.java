package com.mask.demo.dao.sale;

import com.mask.demo.model.sale.SaleOrder;
import com.mask.demo.model.sale.Salesman;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: mac
 * @description: 销售人员数据库方法定义
 * @date: 2020-02-26 17:10
 */
public interface SalesmanMapper {

    /**
     * 分页加载
     * @param start
     * @param end
     * @param name 销售人员姓名，前后模糊匹配
     * @return
     */
    List<Salesman> list(
            @Param("start") int start,
            @Param("end") int end,
            @Param("name") String  name);

    /**
     * 通过id获取销售人员信息
     * @param id
     * @return
     */
    Salesman loadById(@Param("id") Integer id);

    /**
     * 通过姓名搜索销售人员数据
     * @param salesmanName
     * @return
     */
    Salesman loadBySalesmanName(String salesmanName);

    /**
     * 新增销售人员
     * @param salesman
     */
    void insertSalesman(Salesman salesman);

    /**
     * 编辑
     * @param salesman
     */
    void updateSalesman(Salesman salesman);

    /**
     * 删除
     * @param id
     */
    void deleteSalesman(@Param("id") Integer id);
}

package com.mask.demo.controller.sale;

import com.mask.demo.frame.beans.response.IResult;
import com.mask.demo.frame.beans.response.ResultBean;
import com.mask.demo.model.sale.Salesman;
import com.mask.demo.model.system.SysRoleTest;
import com.mask.demo.service.api.sale.SalesmanService;
import com.mask.demo.service.dto.system.PageRange;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: mac
 * @description: 销售人员管理模块
 * @date: 2020-02-26 16:37
 */
@Slf4j
@RestController
@RequestMapping("salesman")
public class SalesmanController {

    @Autowired
    private SalesmanService service;

    /**
     * 分页加载 - 销售人员列表
     * @param page
     * @param limit
     * @param salesmanName
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.POST)
    public IResult listSalesman(String page, String limit, String salesmanName){
        PageRange pageRange = new PageRange(page, limit);
        return new ResultBean<>(service.listSalesman(pageRange, salesmanName));
    }

    /**
     * 新增销售人员
     * @param salesman
     * @return
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public IResult addSalesman(@RequestBody Salesman salesman){
        return new ResultBean<>(service.addSalesman(salesman));
    }

    /**
     * 编辑销售人员信息
     * @param salesman
     * @return
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public IResult updateSalesman(@RequestBody Salesman salesman){
        return new ResultBean<>(service.updateSalesman(salesman));
    }

    /**
     * 删除销售人员
     * @param id
     * @return
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public IResult deleteSalesman(Integer id){
        return new ResultBean<>(service.deleteSalesman(id));
    }

    /**
     * 获取销售人员信息
     * @param id
     * @return
     */
    @RequestMapping(value = "get",method = RequestMethod.POST)
    public IResult getSalesman(Integer id){
        //返回json至前端的均返回ResultBean或者PageResultBean
        return new ResultBean<>(service.getSalesman(id));
    }

}

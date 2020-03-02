package com.mask.demo.controller.produce;

import com.mask.demo.frame.annotation.BizOperLog;
import com.mask.demo.frame.beans.constant.OperType;
import com.mask.demo.frame.beans.response.IResult;
import com.mask.demo.frame.beans.response.ResultBean;
import com.mask.demo.service.api.produce.ProduceService;
import com.mask.demo.service.dto.system.PageRange;
import com.mask.demo.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: mac
 * @description: 产品生产模块
 * @date: 2020-02-26 10:57
 */
@Slf4j
@RestController
@RequestMapping("/produce")
public class ProduceController {

    @Autowired
    private ProduceService service;

    /**
     * 生产记录 - 查看列表
     * @return
     */
    @RequestMapping(value = "list.do", method = RequestMethod.POST)
    public IResult listProductionDaily(String page, String limit, String date){
        PageRange pageRange = new PageRange(page, limit);
        return new ResultBean<>(service.listProductionDaily(pageRange, DateUtil.str2Long(date)));
    }

    /**
     * 生产日报 - 查询当日记录
     * 查询今天是否填写生产日报
     * @return
     */
    @RequestMapping(value = "today", method = RequestMethod.POST)
    public IResult productionDaily(){
        return new ResultBean<>(service.productionDaily());
    }

    /**
     * 生产日报 - 添加生产日报记录
     * 生产数量必填
     * 默认产品 - 口罩
     * 默认今日
     * @return
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    @BizOperLog(operType = OperType.ADD,memo = "添加生产记录")
    public IResult addProduceRecord(Integer number,String mark ){
        return new ResultBean<>(service.addProduceRecord(number, mark));
    }

    /**
     * 生产日报 - 修改生产日报记录
     * @return
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @BizOperLog(operType = OperType.UPDATE,memo = "编辑生产记录")
    public IResult updateProduceRecord(Integer id, Integer number,String mark){
        return new ResultBean<>(service.updateProduceRecord(id, number, mark));
    }

}

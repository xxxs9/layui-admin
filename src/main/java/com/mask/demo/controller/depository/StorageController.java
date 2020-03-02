package com.mask.demo.controller.depository;

import com.mask.demo.frame.beans.response.IResult;
import com.mask.demo.frame.beans.response.ResultBean;
import com.mask.demo.service.api.depository.StorageService;
import com.mask.demo.service.dto.system.PageRange;
import com.mask.demo.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: mac
 * @description: 仓库管理 - 入库记录
 * @date: 2020-02-27 11:25
 */
@Slf4j
@RestController
@RequestMapping("storage")
public class StorageController {

    @Autowired
    private StorageService service;


    /**
     * 分页加载 - 入库记录
     * @param page
     * @param limit
     * @param date          查询条件 - 记录日期
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.POST)
    public IResult listStorageRecord(String page, String limit, String date){
        PageRange pageRange = new PageRange(page, limit);
        return new ResultBean<>(service.listStorageRecord(pageRange, DateUtil.str2Long(date)));
    }
}

package com.mask.demo.service.api.produce;

import com.mask.demo.service.dto.ProductDto;
import com.mask.demo.service.dto.system.PageRange;

import java.util.List;

/**
 * @author: mac
 * @description: 生产业务逻辑定义层
 * @date: 2020-02-26 13:09
 */
public interface ProduceService {

    /**
     * 查看生产列表功能
     * @param pageRange
     * @param date
     * @return
     */
    List<ProductDto> listProductionDaily(PageRange pageRange, Long date);

    /**
     * 查询今日生产情况
     * @return
     */
    ProductDto productionDaily();

    /**
     * 添加今日生产记录
     * @param number
     * @param mark
     * @return
     */
    Boolean addProduceRecord(Integer number,String mark);

    /**
     * 修改今日生产记录
     * @param number
     * @param mark
     * @return
     */
    Boolean updateProduceRecord(Integer id, Integer number,String mark);
}

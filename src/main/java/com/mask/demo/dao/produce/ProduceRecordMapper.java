package com.mask.demo.dao.produce;

import com.mask.demo.model.produce.ProduceRecord;
import com.mask.demo.service.dto.ProductDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: mac
 * @description: 生产记录数据库方法定义
 * @date: 2020-02-26 13:21
 */
public interface ProduceRecordMapper {

    /**
     * 查询历史生产记录
     * @return
     */
    List<ProductDto> list(
            @Param("start") int start,
            @Param("end") int end,
            @Param("date") Long date);

    /**
     * 查询今日生产记录
     * @return
     */
    ProductDto loadByToday();

    /**
     * 添加生产记录
     * @param produceRecord
     */
    void insertProduceRecord(ProduceRecord produceRecord);

    /**
     * 修改生产记录
     * @param produceRecord
     */
    void updateProduceRecord(ProduceRecord produceRecord);

}

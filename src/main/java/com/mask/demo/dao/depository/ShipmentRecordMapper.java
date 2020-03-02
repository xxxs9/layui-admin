package com.mask.demo.dao.depository;

import com.mask.demo.service.dto.depository.ShipmentDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: mac
 * @description: 出库记录数据库 - 操作定义
 * @date: 2020-02-27 11:39
 */
public interface ShipmentRecordMapper {

    /**
     * 分页查询 - 出库记录列表
     * @return
     */
    List<ShipmentDto> listByQuery(
            @Param("start") int start,
            @Param("end") int end,
            @Param("orderNumber") String  name,
            @Param("date") Long date);
}

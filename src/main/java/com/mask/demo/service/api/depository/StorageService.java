package com.mask.demo.service.api.depository;

import com.mask.demo.service.dto.system.PageRange;
import com.mask.demo.service.dto.depository.StorageDto;

import java.util.List;

/**
 * @author: mac
 * @description: 库存管理 - 入库业务逻辑定义
 * @date: 2020-02-27 14:00
 */
public interface StorageService {

    /**
     * 分页加载入库记录
     * @param pageRange
     * @param date
     * @return
     */
    List<StorageDto> listStorageRecord(PageRange pageRange, Long date);

}

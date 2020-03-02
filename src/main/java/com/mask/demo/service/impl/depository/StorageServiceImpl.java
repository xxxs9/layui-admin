package com.mask.demo.service.impl.depository;

import com.mask.demo.dao.depository.StorageRecordDetailMapper;
import com.mask.demo.dao.depository.StorageRecordMapper;
import com.mask.demo.model.depository.StorageRecordDetail;
import com.mask.demo.model.depository.extend.StorageTypeEnum;
import com.mask.demo.model.produce.extend.ProductEnum;
import com.mask.demo.service.api.depository.StorageService;
import com.mask.demo.service.dto.depository.StorageDto;
import com.mask.demo.service.dto.system.PageRange;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: mac
 * @description: 库存管理 - 入库业务逻辑实现
 * @date: 2020-02-27 14:00
 */
@Slf4j
@Service
public class StorageServiceImpl implements StorageService {


    @Autowired
    private StorageRecordMapper storageRecordMapper;

    @Autowired
    private StorageRecordDetailMapper storageRecordDetailMapper;
    
    @Override
    public List<StorageDto> listStorageRecord(PageRange pageRange, Long date) {
        List<StorageDto> dtoList = storageRecordMapper.listByQuery(
                pageRange.getStart(), pageRange.getEnd(), date);
        for (StorageDto dto : dtoList) {
            packDetail(dto);
            packEnum(dto);
        }
        return dtoList;
    }

    /**
     * 装配明细信息
     * @param dto
     */
    private void packDetail(StorageDto dto){
        List<StorageRecordDetail> stdList = storageRecordDetailMapper.listByStorageRecordId(dto.getId());
        if (stdList != null && stdList.size() > 0) {
            dto.setProductId(stdList.get(0).getProductId());
            dto.setProductName(ProductEnum.getProductName(stdList.get(0).getProductId()));
            dto.setNumber(stdList.get(0).getNumber());
        }
    }

    /**
     * 装配枚举信息
     * @param dto
     */
    private void packEnum(StorageDto dto){
        dto.setStorageTypeName(StorageTypeEnum.getStorageTypeName(dto.getStorageTypeId()));
    }
}

package com.mask.demo.dao.depository;

import com.mask.demo.model.depository.StorageRecordDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StorageRecordDetailMapper {

    /**
     * 根据入库记录id获取详情集合
     * @param storageRecordId
     * @return
     */
    List<StorageRecordDetail> listByStorageRecordId(
            @Param("storageRecordId") Integer storageRecordId);

}

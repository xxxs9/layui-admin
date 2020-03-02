package com.mask.demo.dao.depository;

import com.mask.demo.service.dto.depository.StorageDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StorageRecordMapper {

    List<StorageDto> listByQuery(
            @Param("start") int start,
            @Param("end") int end,
            @Param("date") Long date);
}

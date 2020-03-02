package com.mask.demo.dao.produce;

import com.mask.demo.model.produce.ProduceRecordDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: mac
 * @description: 生产记录明细数据库操作定义
 * @date: 2020-02-26 13:21
 */
public interface ProduceRecordDetailMapper {

    /**
     * 根据生产日报id，查询生产日报明细
     * @param produceRecordId
     * @return
     */
    List<ProduceRecordDetail> listByProduceRecordId(@Param("produceRecordId") Integer produceRecordId);

    /**
     * 添加生产明细
     * @param produceRecordDetail
     */
    void insertProduceRecordDetail(ProduceRecordDetail produceRecordDetail);

    /**
     * 修改生产明细
     * @param produceRecordDetail
     */
    void updateProduceRecordDetail(ProduceRecordDetail produceRecordDetail);

}

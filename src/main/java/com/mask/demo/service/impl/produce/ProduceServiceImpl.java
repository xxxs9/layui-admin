package com.mask.demo.service.impl.produce;

import com.mask.demo.dao.produce.ProduceRecordDetailMapper;
import com.mask.demo.dao.produce.ProduceRecordMapper;
import com.mask.demo.model.produce.ProduceRecord;
import com.mask.demo.model.produce.ProduceRecordDetail;
import com.mask.demo.model.produce.extend.ProductEnum;
import com.mask.demo.service.api.produce.ProduceService;
import com.mask.demo.service.dto.ProductDto;
import com.mask.demo.service.dto.system.PageRange;
import com.mask.demo.utils.SessionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: mac
 * @description: 生产业务逻辑实现层
 * @date: 2020-02-26 13:08
 */
@Slf4j
@Service
public class ProduceServiceImpl implements ProduceService {

    @Autowired
    private ProduceRecordMapper produceRecordMapper;

    @Autowired
    private ProduceRecordDetailMapper produceRecordDetailMapper;

    /**
     * 获取历史生产记录集合
     * 可通过date参数，传入数据格式为 YYYY-MM-DD格式的日期，去查询指定日期记录
     * @param pageRange
     * @param date
     * @return
     */
    @Override
    public List<ProductDto> listProductionDaily(PageRange pageRange, Long date) {
        // 分页查询所有列表
        List<ProductDto> dtoList = produceRecordMapper.list(pageRange.getStart(), pageRange.getEnd(), date);
        for (ProductDto dto : dtoList){
            // 获取生产记录明细集合
            packProductDto(dto);
        }
        return dtoList;
    }

    /**
     * 查询今日生产情况
     * @return
     */
    @Override
    public ProductDto productionDaily() {
        ProductDto dto = produceRecordMapper.loadByToday();
        if (dto != null ){
            packProductDto(dto);
        }
        return dto;
    }

    /**
     * 添加今日生产记录
     * @param number
     * @param mark
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean addProduceRecord(Integer number, String mark) {
        // 装填生产日报对象
        ProduceRecord pr = packProduceRecord(mark);
        // 插入生产日报数据
        produceRecordMapper.insertProduceRecord(pr);
        // 装填生产日报明细对象
        ProduceRecordDetail prd = packProduceRecordDetail(pr.getId(), number);
        // 插入生产日报明细数据
        produceRecordDetailMapper.insertProduceRecordDetail(prd);
        return true;
    }

    /**
     * 修改今日生产记录
     * @param number 货品数量
     * @param mark  生产备注
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean updateProduceRecord(Integer id, Integer number, String mark) {
        ProduceRecord pr = packProduceRecord(id, mark);
        produceRecordMapper.updateProduceRecord(pr);
        // 获取原有的明细
        ProduceRecordDetail prd = produceRecordDetailMapper.listByProduceRecordId(id).get(0);
        // 修改数量
        prd.setNumber(number);
        produceRecordDetailMapper.updateProduceRecordDetail(prd);
        return true;
    }

    // --------------- private function ---------------

    /**
     * 详细充填前端返回实体
     * 填充 - 产品id,产品名称,产品数量
     * @param dto
     * @return
     */
    private ProductDto packProductDto(ProductDto dto){
        List<ProduceRecordDetail> prdList = produceRecordDetailMapper.listByProduceRecordId(dto.getId());
        // 取出集合中的第一个产品，填入返回实例中
        if (prdList != null && prdList.size() > 0) {
            dto.setProductId(prdList.get(0).getProductId());
            dto.setNumber(prdList.get(0).getNumber());
            dto.setProductName(ProductEnum.getProductName(dto.getProductId()));
        }
        return dto;
    }

    /**
     * 包装每日生产记录对象
     * @param mark
     * @return
     */
    private ProduceRecord packProduceRecord(String mark){
        return packProduceRecord(null,mark);
    }

    /**
     * 包装每日生产记录对象
     * @param produceRecordId
     * @param mark
     * @return
     */
    private ProduceRecord packProduceRecord(Integer produceRecordId, String mark){
        // 装填生产日报对象
        ProduceRecord pr = new ProduceRecord();
        pr.setId(produceRecordId);
        if (produceRecordId == null ) {
            pr.setCreateDate(System.currentTimeMillis());
            pr.setCreateId(SessionUtil.getSession().getAttribute("sysUserId").toString());
            pr.setIsDel(false);
        }
        pr.setMark(mark);
        return pr;
    }

    /**
     * 包装每日生产记录明细对象
     * @param produceRecordId
     * @param number
     * @return
     */
    private ProduceRecordDetail packProduceRecordDetail(Integer produceRecordId, Integer number){
        return packProduceRecordDetail(null, produceRecordId, number);
    }

    /**
     * 包装每日生产记录明细对象
     * @param produceRecordDetailId
     * @param produceRecordId
     * @param number
     * @return
     */
    private ProduceRecordDetail packProduceRecordDetail(Integer produceRecordDetailId, Integer produceRecordId, Integer number){
        // 装填生产日报明细对象
        ProduceRecordDetail prd = new ProduceRecordDetail();
        prd.setId(produceRecordDetailId);
        prd.setProduceRecordId(produceRecordId);
        prd.setNumber(number);
        prd.setProductId(ProductEnum.FANG_PU_MASK.getProductId());
        return prd;
    }

}

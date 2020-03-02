package com.mask.demo.service.impl.depository;

import com.mask.demo.dao.depository.ShipmentRecordDetailMapper;
import com.mask.demo.dao.depository.ShipmentRecordMapper;
import com.mask.demo.model.depository.ShipmentRecordDetail;
import com.mask.demo.model.depository.extend.ShipmentModeTypeEnum;
import com.mask.demo.model.depository.extend.ShipmentTypeEnum;
import com.mask.demo.model.produce.extend.ProductEnum;
import com.mask.demo.service.api.depository.ShipmentService;
import com.mask.demo.service.dto.depository.ShipmentDto;
import com.mask.demo.service.dto.system.PageRange;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: mac
 * @description: 出库记录业务实现层
 * @date: 2020-02-27 11:29
 */
@Slf4j
@Service
public class ShipmentServiceImpl implements ShipmentService {


    @Autowired
    private ShipmentRecordMapper shipmentRecordMapper;

    @Autowired
    private ShipmentRecordDetailMapper shipmentRecordDetailMapper;

    /**
     * 分页加载出库记录
     * @param pageRange
     * @param orderNumber
     * @param date
     * @return
     */
    @Override
    public List<ShipmentDto> listShipmentRecord(PageRange pageRange, String orderNumber, Long date) {
        List<ShipmentDto> dtoList = shipmentRecordMapper.listByQuery(
                pageRange.getStart(), pageRange.getEnd(), orderNumber, date);
        for (ShipmentDto dto : dtoList) {
            packDetail(dto);
            packEnumName(dto);
        }
        return dtoList;
    }



    /**
     * 状态明细信息
     * @param dto
     */
    private void packDetail(ShipmentDto dto){
        // 获取出库明细集合
        List<ShipmentRecordDetail> srdList =  shipmentRecordDetailMapper.listByShipmentRecordId(dto.getId());
        // 判断出库明细是否存在
        if (srdList != null && srdList.size() > 0) {
            dto.setProductId(srdList.get(0).getProductId());
            dto.setProductName(ProductEnum.getProductName(srdList.get(0).getProductId()));
            dto.setNumber(srdList.get(0).getNumber());
            dto.setCartonBoxNumber(srdList.get(0).getCartonBoxNumber());
        }
    }

    /**
     * 装填枚举类信息
     * @param dto
     */
    private void packEnumName(ShipmentDto dto){
        dto.setShipmentTypeName(ShipmentTypeEnum.getShipmentTypeName(dto.getShipmentTypeId()));
        dto.setShipmentModeTypeName(ShipmentModeTypeEnum.getShipmentModeTypeName(dto.getShipmentModeTypeId()));
    }
}

package com.mask.demo.service.impl.sale;

import com.mask.demo.dao.sale.SalesmanMapper;
import com.mask.demo.frame.utils.CheckUtil;
import com.mask.demo.model.sale.Salesman;
import com.mask.demo.service.api.sale.SalesmanService;
import com.mask.demo.service.dto.system.PageRange;
import com.mask.demo.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: mac
 * @description: TODO
 * @date: 2020-02-26 17:06
 */
@Service
public class SalesmanServiceImpl implements SalesmanService {

    @Autowired
    private SalesmanMapper salesmanMapper;

    /**
     * 获取销售人员列表
     * @param pageRange
     * @param name
     * @return
     */
    @Override
    public List<Salesman> listSalesman(PageRange pageRange, String name) {
        return salesmanMapper.list(pageRange.getStart(), pageRange.getEnd(), name);
    }

    /**
     * 新增销售人员
     * @param salesman
     * @return
     */
    @Override
    public Boolean addSalesman(Salesman salesman) {
        // 先查询是否已有重名记录
        Salesman oldSalesman = salesmanMapper.loadBySalesmanName(salesman.getSalesmanName());
//        if (oldSalesman != null) {
//            // 判断是否是已删除记录
//            if (oldSalesman.getIsDel() == true) {
//                // TODO 提醒用户过去存在重名数据，并返回给客户查看，必要时可衔接恢复数据操作
////                return oldSalesman;
//                throw new DataDuplicationException();
//            }
//            // TODO 提醒用户重名
//            throw new DataDuplicationException();
//        }
        CheckUtil.check(oldSalesman == null,"该销售人员名称已经存在");
        // 正常新建流程
        salesman.setCreateDate(System.currentTimeMillis());
        salesman.setCreateId(SessionUtil.getSession().getAttribute("sysUserId").toString());
        salesman.setIsDel(false);
        salesmanMapper.insertSalesman(salesman);
        return true;
    }

    /**
     * 编辑销售人员
     * @param salesman
     * @return
     */
    @Override
    public Boolean updateSalesman(Salesman salesman) {
        // 先查询是否已有重名记录
        Salesman oldSalesman = salesmanMapper.loadBySalesmanName(salesman.getSalesmanName());
        CheckUtil.check(oldSalesman == null,"该销售人员名称已经存在");
        salesmanMapper.updateSalesman(salesman);
        return true;
    }

    /**
     * 删除人员 - 逻辑删除，数据库保留，前端不显示
     * @param id
     * @return
     */
    @Override
    public Boolean deleteSalesman(Integer id) {
        salesmanMapper.deleteSalesman(id);
        return true;
    }

    /**
     * 通过id获取销售人员信息
     * @param id
     * @return
     */
    @Override
    public Salesman getSalesman(Integer id) {
        return salesmanMapper.loadById(id);
    }
}

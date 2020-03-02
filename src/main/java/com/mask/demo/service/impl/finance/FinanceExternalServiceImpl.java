package com.mask.demo.service.impl.finance;

import com.mask.demo.service.api.finance.FinanceExternalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author: mac
 * @description: 财务模块 - 对外业务逻辑;
 *              该模块所有方法不做事务管理，所有调用该模块的方法需做事务管理
 * @date: 2020-02-28 18:02
 */
@Slf4j
@Service
public class FinanceExternalServiceImpl implements FinanceExternalService {

    @Override
    public void addReceivables() {
        // TODO 生成应收单
    }

    @Override
    public void addReceiptRecord() {
        // TODO 生成应收单
    }

    @Override
    public void addPayable() {
        // TODO 生成应收单
    }

    @Override
    public void addPaymentRecord() {
        // TODO 生成应收单
    }
}

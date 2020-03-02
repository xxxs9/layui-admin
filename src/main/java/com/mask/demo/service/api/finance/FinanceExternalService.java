package com.mask.demo.service.api.finance;

/**
 * @author: mac
 * @description: 财务模块，对其他模块提供服务的业务逻辑层方法定义
 * @date: 2020-02-28 18:03
 */
public interface FinanceExternalService {

    /**
     * 添加应收单
     */
    void addReceivables();

    /**
     * 添加收款记录 - 客户转入
     */
    void addReceiptRecord();

    /**
     * 添加应付单
     */
    void addPayable();

    /**
     * 添加出款记录 - 平台转出
     */
    void addPaymentRecord();


}

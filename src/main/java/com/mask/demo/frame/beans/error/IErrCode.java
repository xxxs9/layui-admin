package com.mask.demo.frame.beans.error;


/**
 * @author: mac
 * @description: 错误码封装
 * @date: 2020-02-25 16:19
 */
public interface IErrCode {

    String getCode();

    String getDesc();

    @Override
    String toString();
}

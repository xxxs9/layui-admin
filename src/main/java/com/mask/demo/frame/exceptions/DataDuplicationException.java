package com.mask.demo.frame.exceptions;

import lombok.Data;

/**
 * @author: mac
 * @description: 定义：数据库插入，发现唯一约束属性重复时，抛出的异常
 * @date: 2020-02-26 17:38
 */
@Data
public class DataDuplicationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * 重名情况，推荐处理的状态码
     */
    private String stateCode;

    /**
     * 出现重名的数据，以json格式返回
     */
    private String jsonData;

    public DataDuplicationException(){

    }

    public DataDuplicationException(String stateCode, String message, String jsonData){
        super(message);
        this.stateCode = stateCode;
        this.jsonData = jsonData;
    }

}

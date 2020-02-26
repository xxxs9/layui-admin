package com.mask.demo.frame.beans.response;

import com.mask.demo.frame.beans.error.IErrCode;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: mac
 * @description: 分页返回封装
 * @date: 2020-02-25 16:20
 */
@Data
public class PageResultBean<T> extends AbstractResult  implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 分页数据,同layui接受的参数名一样
     * */
    private T data;

    /**
     * 记录总数,同layui接受的参数名一样
     * */
    private Integer count;

    public PageResultBean() {
        super();
    }

    /**
     * 构造函数
     * */
    public PageResultBean(T data,Integer count) {
        super();
        this.data = data;
        this.count = count;
    }

    /**
     * 构造函数
     * */
    public PageResultBean(IErrCode e) {
        super();
        this.msg = e.getDesc();
        this.code = e.getCode();
    }

    public PageResultBean(Throwable e) {
        super();
        this.msg = e.toString();
        this.code = SYSTEM_FAIL;
    }

    /**
     * 构造函数
     * */
    public PageResultBean(String code,String msg) {
        super();
        this.msg = msg;
        this.code = code;
    }
}

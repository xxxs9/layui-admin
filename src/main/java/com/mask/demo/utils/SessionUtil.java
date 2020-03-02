package com.mask.demo.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

/**
 * @author: mac
 * @description: 获取sesssion工具类
 * @date: 2020-02-26 16:11
 */
public class SessionUtil {

    /**
     * 通过spring获取request中的session对象
     * @return
     */
    public static HttpSession getSession(){
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
    }
}

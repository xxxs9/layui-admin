package com.mask.demo.frame.utils;

import com.mask.demo.frame.beans.response.AbstractResult;
import com.mask.demo.frame.exceptions.UnloginException;
import org.slf4j.MDC;

/**
 * 用户信息工具类，保存用户信息到threadlocal，方便打印日志
 * Created by leiYao on 2017/11/14.
 */
public class UserInfoUtil {

    private final static ThreadLocal<Object> TL_USER = new ThreadLocal<Object>();

    /**user key*/
    public static final String KEY_USER = "sysUser";//同放入session的用户信息Key

    public static void setUser(Object user) {
        TL_USER.set(user);
        // 把需要打印日志的用户信息放到slf4j MDC
        MDC.put(KEY_USER, user.toString());
    }

    /**
     * 如果没有登录会抛出异常
     * @return
     */
    public static Object getUser() {
        Object user = TL_USER.get();

        if (user == null) {
            throw new UnloginException(AbstractResult.SYSTEM_FAIL,"user unlogin");
        }

        return user;
    }

    /**
     * 如果没有登录，返回null
     * @return
     */
    public static Object getUserIfLogin() {
        return TL_USER.get();
    }

    /**
     * 清空用户信息
     * */
    public static void clearAllUserInfo() {
        TL_USER.remove();
        MDC.remove(KEY_USER);
    }
}

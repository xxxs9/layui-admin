package com.mask.demo.service.api.system;

import com.mask.demo.service.dto.system.LoginResponse;

/**
 * 登录业务服务
 * Created by gameloft9 on 2017/12/5.
 */
public interface LoginService {

    /**
     * 登录
     * @param loginName 登录名
     * @param pwd 密码
     * */
    LoginResponse login(String loginName, String pwd, String code);

    /**
     * 登出
     * */
    String logout();
}

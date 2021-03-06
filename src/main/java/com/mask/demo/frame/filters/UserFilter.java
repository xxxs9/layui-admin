package com.mask.demo.frame.filters;

import com.mask.demo.frame.utils.UserInfoUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author: mac
 * @description: 用户信息filter
 * @date: 2020-02-25 16:20
 */
public class UserFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void destroy() {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        fillUserInfo((HttpServletRequest) request);

        chain.doFilter(request, response);

        clearAllUserInfo();//必须清理，否则tomcat会重用，导致保留的是上次的用户信息
    }

    /**
     * 清空用户信息
     * */
    private void clearAllUserInfo() {
        UserInfoUtil.clearAllUserInfo();
    }

    /**
     * 保存用户信息
     * */
    private void fillUserInfo(HttpServletRequest request) {
        // 用户信息
        Object user = getUserFromSession(request);

        if (user != null) {
            UserInfoUtil.setUser(user);
        }
    }

    /**
     * 从SESSION获取用户信息
     * */
    private Object getUserFromSession(HttpServletRequest request) {
        HttpSession session = request.getSession(true);

        if (session == null) {
            return null;
        }

        // 从session中获取用户信息放到thread local中
        return session.getAttribute(UserInfoUtil.KEY_USER);
    }

}

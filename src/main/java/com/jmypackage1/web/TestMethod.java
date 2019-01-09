package com.jmypackage1.web;

import com.jmypackage1.pojo.User;
import com.jmypackage1.service.IUserService;
import com.jmypackage1.service.UserServiceImpl;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/*拦截 请求*/
public class TestMethod implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest   req, HttpServletResponse resp, Object o) throws Exception {
        Cookie[] cookies = req.getCookies();
        Map<String, Cookie> map = getCookie(cookies);
        Cookie cookie = map.get("name");
        if (cookie == null) {
            resp.sendRedirect("login.do");
        }else {
            return true;
        }
            return false;
        }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

        System.out.println(2);
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

        System.out.println(3);
    }
    public static Map<String, Cookie> getCookie(Cookie[] cookies) {
        Map<String, Cookie> map = new HashMap<>();
        if (cookies != null) {
            for (Cookie cookie : cookies
            ) {
                map.put(cookie.getName(), cookie);
            }
        }
        return map;
    }
}

package com.matty.demo.Interceptor;

import com.matty.demo.entity.UmsMember;
import com.matty.demo.service.UmsMemberService;
import com.matty.demo.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    UmsMemberService umsMemberService;
    @Autowired
    TokenUtil tokenUti;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        String username = tokenUti.getUserNameFromToken(token);
        UmsMember umsMember = umsMemberService.getByOne(username);
        if (umsMember == null){
            throw new RuntimeException("401");
        }
//        boolean is = tokenUti.validateToken(token,umsMember);
//        if (!is){
//            throw new RuntimeException("401");
//        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}

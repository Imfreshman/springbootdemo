package com.example.demo.controller;

import com.example.demo.entity.Person;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class InterCepter implements HandlerInterceptor {
    /*
    处理之前
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截之前");
        System.out.println("web的路径:URI"+request.getRequestURI());
        HttpSession session=request.getSession();
        Person person= (Person) session.getAttribute("person");
        if(person==null){//表示student过期或者未登录
            response.sendRedirect("/person/loginview");
            return false;//不放过
        }else {
            System.out.println(person.toString());
            return true;//放过
        }
    }

    /*
    处理之后
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("拦截之后");
    }

    /*
    最后的处理
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        System.out.println("所有的都完成");
    }
}

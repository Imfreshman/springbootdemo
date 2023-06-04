package com.example.demo.configuration;

import com.example.demo.controller.InterCepter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class LoginInterceptor implements WebMvcConfigurer {
    public void addInterceptors(InterceptorRegistry registry) {

        System.out.println("拦截器生效");
        //放路径
        List<String> list=new ArrayList<>();
        list.add("/person/sturole");
        list.add("/person/loginview");//不能拦截
        list.add("/person/stulogin");//提交登录不能拦截
        InterCepter interCepter=new InterCepter();
        registry.addInterceptor(interCepter).addPathPatterns("/**").excludePathPatterns(list);
    }
}

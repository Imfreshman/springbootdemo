package com.example.demo.configuration;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyPlusConfig {
    @Bean
    public MybatisPlusInterceptor xxxx(){
        MybatisPlusInterceptor my = new MybatisPlusInterceptor();
        PaginationInnerInterceptor pa = new PaginationInnerInterceptor(DbType.MYSQL);
        my.addInnerInterceptor(pa);
        return my;
    }

}

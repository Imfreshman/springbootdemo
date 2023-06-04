package com.example.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PersonMapper extends BaseMapper<Person> {
    @Select("SELECT id,name,age,sex,card_id, from person where card_id=2")
    List<Person> listManagerRole();

    @Select("SELECT id,name,age,sex,card_id, from person where card_id=1")
    List<Person> listUserRole();
}

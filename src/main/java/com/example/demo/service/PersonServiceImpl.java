package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.PersonMapper;
import com.example.demo.entity.Person;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper , Person> implements PersonService{

    @Resource
    private PersonMapper personMapper;

    @Override
    public List<Person> listManagerRole() {
        return personMapper.listManagerRole();
    }

    @Override
    public List<Person> listUserRole() {
        return personMapper.listUserRole();
    }
}

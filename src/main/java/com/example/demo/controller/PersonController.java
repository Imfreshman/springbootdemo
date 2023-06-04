package com.example.demo.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("/add")
    public String add(Person person){
        personService.save(person);
        return "redirect:/person/list";
    }

    @GetMapping("/addview")
    public String addview(){
        return "personAdd";
    }

    @GetMapping("/list")
    public String list(Model model){
        Page<Person> page=new Page<>(1,5);
        Page<Person> list=personService.page(page);
        //键值对，键=字符串，值=java对象Object
        model.addAttribute("person",list.getRecords());
        return "person";   //返回网页的名字（包括路径eg:templates下面的模板

    }

    @GetMapping("/find/{id}")
    public String find(@PathVariable Integer id,Model model) {
        System.out.println("id=" + id);
        Person person = personService.getById(id);
        model.addAttribute("person", person);

        return "personEdit";
    }
    @GetMapping("/del/{id}")
    public String del(@PathVariable Integer id,Model model){

        Person person = personService.getById(id);
        model.addAttribute("person", person);
        return "person";
    }
}

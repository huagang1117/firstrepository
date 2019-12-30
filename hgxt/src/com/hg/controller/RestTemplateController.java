package com.hg.controller;

import com.hg.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/rest")
public class RestTemplateController {
    @RequestMapping(value="/user/{id}",method= RequestMethod.GET)
    public String get(@PathVariable("id") Integer id){
        System.out.println("get"+id);
        return "restindex";
    }

    @RequestMapping(value="/user/{id}",method=RequestMethod.POST)
    public String post(@PathVariable("id") Integer id){
        System.out.println("post"+id);
        return "restindex";
    }

    @RequestMapping(value="/user/{id}",method=RequestMethod.PUT)
    public String put(@PathVariable("id") Integer id){
        System.out.println("put"+id);
        return "restindex";
    }

    @RequestMapping(value="/user/{id}",method=RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id){
        System.out.println("delete"+id);
        return "restindex";
    }

    @ResponseBody
    @RequestMapping("/jsonperson")
    public Person get(){
        Person p = new Person();
        p.setAge(37);
        p.setName("华刚");
        return p;
    }
}

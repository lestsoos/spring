package com.lestsoos.springboot.controller;

import com.lestsoos.springboot.domain.Classes;
import com.lestsoos.springboot.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/classess")
public class ClassesController {


    @Autowired
    private ClassesService classesService;

    @RequestMapping
    public String classes(ModelMap map){
         //classesService.findAll();
        map.addAttribute("classesList",classesService.findAll());

        return "classes/allList";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String toAdd(ModelMap map) {
        map.addAttribute("classes", new Classes());
        map.addAttribute("action", "add");

        return "classes/form";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(@ModelAttribute Classes classes){
        classes.setStaus("1");
        classesService.add(classes);
        return "redirect:/classess";

    }

}

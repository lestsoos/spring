package com.lestsoos.springboot.controller;

import com.lestsoos.springboot.domain.Classes;
import com.lestsoos.springboot.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

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
    public String add(ModelMap map,@ModelAttribute @Valid Classes classes,
                      BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            map.addAttribute("action", "update");
            return "classes/form";
        }
        classes.setStatus("1");
        classesService.add(classes);
        return "redirect:/classess";

    }

    @RequestMapping(value = "/update/{id}",method = RequestMethod.GET)
    public String toUpdate(@PathVariable String id,ModelMap map){
        map.addAttribute("classes", classesService.find(id));
        map.addAttribute("action", "update");
        return "classes/form";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(ModelMap map,@ModelAttribute @Valid Classes classes,
                         BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            map.addAttribute("action", "update");
            return "classes/form";
        }
        classes.setStatus("1");
        classesService.update(classes);
        return "redirect:/classess";
    }

    @RequestMapping(value = "/delete/{id}" , method = RequestMethod.GET)
    public String delete(@PathVariable String id){
        classesService.delete(id);
        return "redirect:/classess";
    }

}

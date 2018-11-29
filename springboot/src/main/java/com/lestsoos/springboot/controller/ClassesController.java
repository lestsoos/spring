package com.lestsoos.springboot.controller;

import com.lestsoos.springboot.domain.All;
import com.lestsoos.springboot.domain.Classes;
import com.lestsoos.springboot.domain.Utils;
import com.lestsoos.springboot.repository.ClassesRepostiory;
import com.lestsoos.springboot.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/classess")
public class ClassesController {


    @Autowired
    private ClassesService classesService;

    @Resource
    private ClassesRepostiory classesRepostiory;

    @ResponseBody
    @RequestMapping(value = "/all")
    public List<All> classesAll(ModelMap map){

        List<Object[]> objects = classesRepostiory.getAllList();
        List<All> alls = null;
        try {
            alls = Utils.castEntity(objects, All.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return alls;
    }

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

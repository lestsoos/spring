package com.lestsoos.springboot.service.impl;

import com.lestsoos.springboot.constant.ConstantValue;
import com.lestsoos.springboot.domain.Classes;
import com.lestsoos.springboot.repository.ClassesRepostiory;
import com.lestsoos.springboot.service.ClassesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClassesServiceImpl implements ClassesService {

    @Resource
    public  ClassesRepostiory classesRepostiory;

    @Override
    public List<Classes> findAll(){
        return this.classesRepostiory.findAllByStausOrderByAddtimeDesc(ConstantValue.CLASS_STATUS_1);
    }

    @Override
    public Classes add(Classes classes){
        return this.classesRepostiory.save(classes);
    }
}

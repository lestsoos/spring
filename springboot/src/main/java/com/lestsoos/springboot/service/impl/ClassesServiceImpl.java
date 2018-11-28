package com.lestsoos.springboot.service.impl;

import com.lestsoos.springboot.constant.ConstantValue;
import com.lestsoos.springboot.domain.Classes;
import com.lestsoos.springboot.repository.ClassesRepostiory;
import com.lestsoos.springboot.service.ClassesService;
import org.hibernate.annotations.OrderBy;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClassesServiceImpl implements ClassesService {

    @Resource
    public  ClassesRepostiory classesRepostiory;

    @Override
    public List<Classes> findAll(){
        Sort sort = new Sort(Sort.Direction.DESC, "addtime");

        return this.classesRepostiory.findAll(sort);

    }

    @Override
    public Classes add(Classes classes){
        return this.classesRepostiory.save(classes);
    }

    @Override
    public Classes delete(String id){
        Classes classes = this.classesRepostiory.findById(id).get();
        classesRepostiory.deleteById(id);
        return classes;

    }

    @Override
    public Classes find(String id){
        return this.classesRepostiory.findById(id).get();
    }

    @Override
    public Classes update(Classes classes) {
        return this.classesRepostiory.save(classes);
    }



}

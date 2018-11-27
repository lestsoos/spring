package com.lestsoos.springboot.service;

import com.lestsoos.springboot.domain.Classes;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ClassesService {

    public List<Classes> findAll();


    public Classes add(Classes classes);

}


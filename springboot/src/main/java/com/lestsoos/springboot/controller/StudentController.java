package com.lestsoos.springboot.controller;

import com.lestsoos.springboot.domain.Student;
import com.lestsoos.springboot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;


    @RequestMapping(method = RequestMethod.GET)
    public List<Student> students(){
        return this.studentRepository.findAll();
    }
}

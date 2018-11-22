package com.lestsoos.springboot.web;

import com.lestsoos.springboot.domain.model.Student;
import com.lestsoos.springboot.domain.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;


    @GetMapping(value = "/students")
    public List<Student> students(){
        return this.studentRepository.findAll();
    }
}

package com.lestsoos.springboot.domain.repository;

import com.lestsoos.springboot.domain.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,String> {
}

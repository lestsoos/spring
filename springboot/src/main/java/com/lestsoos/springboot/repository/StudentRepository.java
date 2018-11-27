package com.lestsoos.springboot.repository;

import com.lestsoos.springboot.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,String> {
}

package com.lestsoos.springboot.repository;

import com.lestsoos.springboot.domain.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClassesRepostiory extends JpaRepository<Classes,String> {


    //public List<Classes> findAllOrderByAddtimeDesc(@Param("status") String status);

    //public List<Classes> findClassesOrderByAddtimeDesc(@Param("status") String status);

    //public List<Classes> find
    //findByStatusOrderByAddtimeDesc(@Param("status") String status);


}

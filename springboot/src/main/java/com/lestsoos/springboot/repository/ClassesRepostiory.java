package com.lestsoos.springboot.repository;

import com.lestsoos.springboot.domain.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClassesRepostiory extends JpaRepository<Classes,String> {


    //public List<Classes> findAllOrderByAddtimeDesc(@Param("status") String status);

    //public List<Classes> findClassesOrderByAddtimeDesc(@Param("status") String status);

    //public List<Classes> find
    //findByStatusOrderByAddtimeDesc(@Param("status") String status);

    @Query
            (
                    value = "select '张三' as name,'棒极' as classesname,3 as age,1.61 as hig,sysdate as addtime from dual",
                    nativeQuery = true
            )
    public List<Object[]> getAllList();


}

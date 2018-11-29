package com.lestsoos.springboot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
public class All {

    private String name;
    private String classesname;
    private BigDecimal age;
    private Date addtime;
}

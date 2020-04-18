package com.abc.bean;

import lombok.Data;

import java.util.List;

@Data
public class Student {
    private Integer id;
    private String name;
    private Integer age;
    private List<Order> ords;
}

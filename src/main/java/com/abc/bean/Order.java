package com.abc.bean;

import lombok.Data;

@Data
public class Order {
    private Integer id;
    private String name;
    private String note;
    private Integer stdId;
    private Student std;
}

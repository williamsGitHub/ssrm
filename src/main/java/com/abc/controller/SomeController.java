package com.abc.controller;


import com.abc.bean.Student;
import com.abc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/some")
public class SomeController {

    @Autowired
    StudentService service;

    @RequestMapping("/someHandler")
    public  String someHandler(){
        return "this is someHandle";
    }

    @RequestMapping("/getStudentById/{id}")
    public Student getStudent1(@PathVariable Integer id){
        return service.getStudentById1(id);
    }



}

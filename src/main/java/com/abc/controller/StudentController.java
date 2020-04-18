package com.abc.controller;

import com.abc.bean.Order;
import com.abc.bean.Student;
import com.abc.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping("/saveStudent")
    public void saveStudent(Student student) throws Exception {
        service.saveStudent(student);
        System.out.println("存储成功------");
    }

    @GetMapping("/getStudent/{id}")
    @ResponseBody
    public Student getStudentById(@PathVariable("id") Integer id){
        return service.getStudentById(id);
    }

    @RequestMapping("/getCustomById")
    @ResponseBody
    public Student getCustomById(){
        Student s = new Student();
        s.setAge(23);
        s.setName("王五");
        s.setId(1);
        return s;
    }

    @RequestMapping("/getString")
    public String getString(){
        return "r3wewe";
    }

    @RequestMapping("/getStuByAge")
    public List<Student> getStuByAge(@Param(value="age") Integer age){
        return service.getStuByAge(age);
    }

    @RequestMapping("/insertStu")
    public Integer insertStu(Student student){
        return service.insertStu(student);
    }

    @RequestMapping("/getOrderInfo/{id}")
    @ResponseBody
    public Order getOrderInfo(@PathVariable("id") Integer id){
        return service.getOrderInfo(id);
    }

    @RequestMapping("/getStdInfo/{id}")
    @ResponseBody
    public List<Student> getStdInfo(@PathVariable("id") Integer id){
        return service.getStdInfo(id);
    }

    @GetMapping("/getAllStd")
    @ResponseBody
    public PageInfo<Student> getAllStd(@Param(value="pageNum") Integer pageNum,
                                       @Param(value="pageSize") Integer pageSize,
                                       @Param(value="navigatePages") Integer navigatePages){
        PageHelper.startPage(pageNum,pageSize);
        List<Student> allStd = service.getAllStd();
        PageInfo<Student> pageInfo = new PageInfo<>(allStd);
        return pageInfo;
    }

}

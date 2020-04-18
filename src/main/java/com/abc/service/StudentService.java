package com.abc.service;

import com.abc.bean.Order;
import com.abc.bean.Student;

import java.util.List;

public interface StudentService {
    void saveStudent(Student student) throws Exception;
    Student getStudentById(Integer id);
    Student getStudentById1(Integer id);
    List<Student> getStuByAge(Integer age);
    Integer insertStu(Student stu);
    Order getOrderInfo(Integer id);

    List<Student> getStdInfo(Integer id);

    List<Student> getAllStd();
}

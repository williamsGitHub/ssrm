package com.abc.dao;

import com.abc.bean.Order;
import com.abc.bean.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentDao {
    void insertStudent(Student student);

    Student selectById(int id);

    @Select("select * from student where id = #{id}")
    Student selectById1(int id);

    List<Student> getStuByAge(int age);

    Integer insertStu(Student student);


    Order getOrderInfo(Integer id);

    List<Student> getStdInfo(Integer id);

    List<Student> getAllStd();
}

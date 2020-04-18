package com.abc.service;

import com.abc.bean.Order;
import com.abc.bean.Student;
import com.abc.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao dao;

    @Override
    // Spring对于事务的默认提交方式是：发生运行时异常回滚，发生受查异常提交
    @Transactional(rollbackFor = Exception.class)
    public void saveStudent(Student student){
        try {
            dao.insertStudent(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // int i = 5 / 0;   // 运行时异常
        // if(true) {
        //     // 受查异常
        //     throw new Exception("这是我自定义的异常");
        // }
        // dao.insertStudent(student);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Student getStudentById(Integer id) {
        return dao.selectById(id);
    }

    @Override
    @Transactional
    public Student getStudentById1(Integer id) {
        return dao.selectById1(id);
    }

    @Override
    public List<Student> getStuByAge(Integer age) {
        return dao.getStuByAge(age);
    }

    @Override
    public Integer insertStu(Student stu) {
        return dao.insertStu(stu);
    }

    @Override
    public Order getOrderInfo(Integer id) {
        return dao.getOrderInfo(id);
    }

    @Override
    public List<Student> getStdInfo(Integer id) {
        return dao.getStdInfo(id);
    }

    @Override
    public List<Student> getAllStd() {
        return dao.getAllStd();
    }
}

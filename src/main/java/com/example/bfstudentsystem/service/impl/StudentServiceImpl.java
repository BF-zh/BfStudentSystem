package com.example.bfstudentsystem.service.impl;

import com.example.bfstudentsystem.entity.Student;
import com.example.bfstudentsystem.mapper.StudentMapper;
import com.example.bfstudentsystem.service.StudentService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author bf
 * @date 2023/6/21
 **/
@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    StudentMapper mapper;

    @Override
    public String createStudent(String username, int sex) {
        int i = mapper.createStudent(username, sex);
        return i >= 1 ? "创建成功" : "创建失败";
    }

    @Override
    public String delStudent(int id) {
        int i = mapper.delStudentById(id);
        return i >= 1 ? "删除成功" : "删除失败";
    }

    @Override
    public String delStudent(int[] ids) {
        int i = mapper.delStudentByIds(ids);
        return i >= 1 ? "删除成功" : "删除失败";
    }

    @Override
    public String updateStudent(Student student) {
        int i = mapper.updateStudent(student);
        return i >= 1 ? "更新信息成功" : "更新信息失败";
    }

    @Override
    public Student findStudent(int id) {
        return mapper.findStudentById(id);
    }

    @Override
    public List<Student> findStudent(String username) {
        return mapper.findStudentByUserName(username);
    }
}

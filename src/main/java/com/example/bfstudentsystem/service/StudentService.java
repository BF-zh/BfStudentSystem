package com.example.bfstudentsystem.service;

import com.example.bfstudentsystem.entity.Student;

import java.util.List;

/**
 * @author bf
 * @date 2023/6/21
 **/
public interface StudentService {
    String createStudent(String username, int sex);

    String delStudent(int id);

    String delStudent(int[] ids);

    String updateStudent(Student student);

    Student findStudent(int id);

    List<Student> findStudent(String username);
}

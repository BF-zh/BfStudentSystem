package com.example.bfstudentsystem.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author bf
 * @date 2023/6/21
 **/
@Data
public class Student {
    private int id;
    private String username;
    private LocalDateTime birthday;
    private String sex;
    private String phone;
}

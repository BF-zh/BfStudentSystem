package com.example.bfstudentsystem.entity.user;

import lombok.Data;

import java.time.LocalDate;

/**
 * @author bf
 */
@Data
public class AccountUser {
    int id;
    String username;
    String email;
    int type;
    LocalDate birthday;
    int sex;
}
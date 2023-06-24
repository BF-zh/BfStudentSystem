package com.example.bfstudentsystem.entity.user;

import lombok.Data;

import java.time.LocalDate;

/**
 * @author bf
 * @date 2023/6/24
 **/
@Data
public class AccountUserDTo {
    int id;
    String username;
    String email;
    int type;
    LocalDate birthday;
    int sex;
}

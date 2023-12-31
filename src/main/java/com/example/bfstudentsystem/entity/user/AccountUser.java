package com.example.bfstudentsystem.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    String password;
    int type;
    LocalDate birthday;
    int sex;
    String nickname;
}
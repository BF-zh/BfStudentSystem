package com.example.bfstudentsystem.entity.auth;

import lombok.Data;

/**
 * @author bf
 */
@Data
public class Account {
    int id;
    String email;
    String username;
    String password;
}

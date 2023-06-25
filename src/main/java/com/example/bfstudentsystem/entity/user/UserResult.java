package com.example.bfstudentsystem.entity.user;

import com.example.bfstudentsystem.entity.auth.Account;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

/**
 * @author bf
 * @date 2023/6/24
 **/
@Data
@AllArgsConstructor
public class UserResult {
    private int count;
    private List<AccountUser> list;
}
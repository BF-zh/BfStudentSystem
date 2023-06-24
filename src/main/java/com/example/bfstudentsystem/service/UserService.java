package com.example.bfstudentsystem.service;

import com.example.bfstudentsystem.entity.user.AccountUser;

import java.util.List;

/**
 * @author bf
 * @date 2023/6/24
 **/
public interface UserService {
    List<AccountUser> findUser(AccountUser user, String keyword, int userId);

    boolean delUser(int[] ids);

    boolean updateUser(AccountUser user);

    boolean updateUser(AccountUser[] users);

    boolean accountExists(String user);

    boolean addUser(String email, String username, String password, int sex, int type);
}

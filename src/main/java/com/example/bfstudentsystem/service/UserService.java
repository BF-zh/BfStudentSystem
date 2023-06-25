package com.example.bfstudentsystem.service;

import com.example.bfstudentsystem.entity.user.AccountUser;
import com.example.bfstudentsystem.entity.user.UserResult;

/**
 * @author bf
 * @date 2023/6/24
 **/
public interface UserService {
    UserResult findUser(AccountUser user, String keyword, int limit, int offset, int userType);

    boolean delUser(int[] ids);

    boolean updateUser(AccountUser user);

    boolean updateUser(AccountUser[] users);

    boolean accountExists(String user);

    boolean addUser(AccountUser user);
}

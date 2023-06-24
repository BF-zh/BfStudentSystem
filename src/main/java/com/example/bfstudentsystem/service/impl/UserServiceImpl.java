package com.example.bfstudentsystem.service.impl;

import com.example.bfstudentsystem.entity.user.AccountUser;
import com.example.bfstudentsystem.mapper.UserMapper;
import com.example.bfstudentsystem.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author bf
 * @date 2023/6/24
 **/
@Service
public class UserServiceImpl implements UserService {
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    @Resource
    UserMapper userMapper;

    @Override
    public List<AccountUser> findUser(AccountUser user, String keyword, int userId) {
        List<AccountUser> user1 = userMapper.findUser(user, keyword, userId);
        System.out.println(user1);
        return user1;
    }

    @Override
    public boolean delUser(int[] id) {
        return userMapper.deleteUser(id) >= 1;
    }

    @Override
    public boolean updateUser(AccountUser user) {
        if (user.getPassword() != null) {
            user.setPassword(encoder.encode(user.getPassword()));
        }
        return userMapper.updateUser(user) >= 1;
    }

    @Override
    public boolean updateUser(AccountUser[] users) {
        return false;
    }

    @Override
    public boolean accountExists(String user) {
        return userMapper.findAccountByNameOrEmail(user) != null;
    }

    @Override
    public boolean addUser(String email, String username, String password, int sex, int type) {
        return userMapper.addUser(email, username, encoder.encode(password), sex, type) >= 1;
    }
}

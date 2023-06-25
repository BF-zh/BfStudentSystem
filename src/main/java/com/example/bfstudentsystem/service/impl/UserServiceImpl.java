package com.example.bfstudentsystem.service.impl;

import com.example.bfstudentsystem.entity.auth.Account;
import com.example.bfstudentsystem.entity.user.AccountUser;
import com.example.bfstudentsystem.entity.user.UserResult;
import com.example.bfstudentsystem.mapper.UserMapper;
import com.example.bfstudentsystem.service.UserService;
import jakarta.annotation.Resource;
import lombok.extern.java.Log;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StreamUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public UserResult findUser(AccountUser user, String keyword, int limit, int page, int userType) {
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("userType", userType);
        paramMap.put("user", user);
        paramMap.put("keyword", keyword);
        paramMap.put("limit", limit);
        paramMap.put("offset", (page - 1) * limit);

        List<AccountUser> list = userMapper.findUser(paramMap);
        int totalCount = userMapper.countUsers(paramMap);

        return new UserResult(totalCount, list);
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
    public boolean addUser(AccountUser user) {
        if (ObjectUtils.isEmpty(user.getPassword())) {
            user.setPassword(encoder.encode("123456"));
        }else {
            user.setPassword(encoder.encode(user.getPassword()));
        }
        if(ObjectUtils.isEmpty(user.getSex())){
            user.setSex(0);
        }
        if(ObjectUtils.isEmpty(user.getType())){
            user.setType(0);
        }
        return userMapper.addUser(user) >= 1;
    }
}

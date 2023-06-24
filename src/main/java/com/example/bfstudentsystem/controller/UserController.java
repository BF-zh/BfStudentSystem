package com.example.bfstudentsystem.controller;

import com.example.bfstudentsystem.entity.RestBean;
import com.example.bfstudentsystem.entity.user.AccountUser;
import com.example.bfstudentsystem.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author bf
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Resource
    UserService userService;

    @GetMapping("/me")
    public RestBean<AccountUser> me(@SessionAttribute("account") AccountUser user) {
        return RestBean.success(user);
    }

    @GetMapping("/list")
    public RestBean<List<AccountUser>> list(AccountUser user, String keyword, @SessionAttribute("account") AccountUser me) {
        System.out.println(user);
        System.out.println(keyword);
        return RestBean.success(userService.findUser(user, keyword, me.getId()));
    }

    @PostMapping("/add")
    public RestBean<String> adduser(String email, String username, String password, int sex, int type) {
        if (userService.accountExists(username)) {
            return RestBean.fail(400, "用户名已存在");
        }
        if (userService.accountExists(email)) {
            return RestBean.fail(400, "邮箱已存在");
        }
        if (userService.addUser(email, username, password, sex, type)) {
            return RestBean.success("添加成功");
        }
        return RestBean.fail(400, "添加失败");

    }

    @PostMapping("/delete")
    public RestBean<String> deleteUser(int[] ids) {
        if (userService.delUser(ids)) {
            return RestBean.success("删除成功");
        }
        return RestBean.fail(400, "删除失败");
    }

    @PostMapping("/update")
    public RestBean<String> updateUser(AccountUser user) {
        System.out.println(user);
        if (userService.updateUser(user)) {
            return RestBean.success("更新成功");
        }
        return RestBean.fail(400, "更新失败");
    }

}

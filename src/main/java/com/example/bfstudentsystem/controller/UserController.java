package com.example.bfstudentsystem.controller;

import com.example.bfstudentsystem.entity.RestBean;
import com.example.bfstudentsystem.entity.user.AccountUser;
import com.example.bfstudentsystem.entity.user.UserResult;
import com.example.bfstudentsystem.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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
    public RestBean<UserResult> list(AccountUser user, String keyword, int limit, int page, @SessionAttribute("account") AccountUser me) {
        return RestBean.success(userService.findUser(user, keyword,limit,page,me.getType()));
    }

    @PostMapping("/add")
    public RestBean<String> adduser(AccountUser user) {
        if (userService.accountExists(user.getUsername())) {
            return RestBean.fail(400, "用户名已存在");
        }
        if (userService.accountExists(user.getEmail())) {
            return RestBean.fail(400, "邮箱已存在");
        }
        if (userService.addUser(user)) {
            return RestBean.success("添加成功");
        }
        return RestBean.fail(400, "添加失败");

    }

    @PostMapping("/delete")
    public RestBean<String> deleteUser(@RequestParam("ids") String ids) {
        int[] idArray = Arrays.stream(ids.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(idArray);
        if (userService.delUser(idArray)) {
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

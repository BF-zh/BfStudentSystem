package com.example.bfstudentsystem.mapper;

import com.example.bfstudentsystem.entity.auth.Account;
import com.example.bfstudentsystem.entity.user.AccountUser;
import com.example.bfstudentsystem.entity.user.UserResult;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author bf
 */
@Mapper
public interface UserMapper {
    @Select("select * from db_account where username = #{text} or email = #{text}")
    Account findAccountByNameOrEmail(String text);

    @Select("select * from db_account where username = #{text} or email = #{text}")
    AccountUser findAccountUserByNameOrEmail(String text);

    @Insert("insert into db_account (email, username, password) values (#{email}, #{username}, #{password})")
    int createAccount(String username, String password, String email);

    @Update("update db_account set password = #{password} where email = #{email}")
    int resetPasswordByEmail(String password, String email);

    List<AccountUser> findUser(Map<String, Object> paramMap);
    int countUsers(Map<String, Object> paramMap);
    int deleteUser(int[] ids);

    int addUser(AccountUser user);

    int updateUser(@Param("user") AccountUser user);

}

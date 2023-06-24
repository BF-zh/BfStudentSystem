package com.example.bfstudentsystem.mapper;

import com.example.bfstudentsystem.entity.auth.Account;
import com.example.bfstudentsystem.entity.user.AccountUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

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

    List<AccountUser> findUser(@Param("user") AccountUser user, @Param("keyword") String keyword, @Param("userId") int userId);

    int deleteUser(int[] ids);

    int addUser(String email, String username, String password, int sex, int type);

    int updateUser(@Param("user") AccountUser user);

}

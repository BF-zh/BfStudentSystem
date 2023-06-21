package com.example.bfstudentsystem.mapper.provider;

import com.example.bfstudentsystem.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.UpdateProvider;
import org.jetbrains.annotations.NotNull;

/**
 * @author bf
 */
public interface StudentMapperProvider {
    @UpdateProvider(type = StudentMapperProvider.class, method = "updateStudentSql")
    void updateStudent(@Param("student") Student student);

    default String updateStudentSql(@NotNull Student student) {
        StringBuilder sql = new StringBuilder("UPDATE db_student SET");
        if (student.getUsername() != null) {
            sql.append(" username = #{student.username},");
        }
        if (student.getSex() != null) {
            sql.append(" sex = #{student.sex},");
        }
        if (student.getBirthday() != null) {
            sql.append(" birthday = #{student.birthday},");
        }
        if (student.getPhone() != null) {
            sql.append(" phone = #{student.phone},");
        }
        sql.deleteCharAt(sql.length() - 1);  // 删除最后一个逗号
        sql.append(" WHERE id = #{student.id}");
        return sql.toString();
    }
}

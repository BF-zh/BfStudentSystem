package com.example.bfstudentsystem.mapper;

import com.example.bfstudentsystem.entity.Student;
import com.example.bfstudentsystem.mapper.provider.StudentMapperProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author bf
 * @date 2023/6/21
 **/
@Mapper
public interface StudentMapper {
    @Insert("insert into db_student (username, sex) values (#{username}, #{sex})")
    int createStudent(String username, int sex);

    @Delete("delete from db_student where id =#{id}")
    int delStudentById(int id);

    @Delete("delete from db_student where id in #{ids}")
    int delStudentByIds(int[] ids);

    @UpdateProvider(type = StudentMapperProvider.class, method = "updateStudentSql")
    int updateStudent(Student student);


    @Select("select  * from db_student where id = #{id} ")
    Student findStudentById(int id);

    @Select("select  * from db_student where username like concat('%',#{username},'%')")
    List<Student> findStudentByUserName(String username);
}

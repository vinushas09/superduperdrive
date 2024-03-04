package com.udacity.jwdnd.course1.cloudstorage.Mapper;


import com.udacity.jwdnd.course1.cloudstorage.Entity.Users;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO USERS (username, salt, password, firstname, lastname) VALUES(#{username}, #{salt}, #{password}, #{firstName}, #{lastName})")
    @Options(useGeneratedKeys = true, keyProperty = "userid")
    int insertUser(Users users);

    @Select("SELECT * FROM USERS WHERE username = #{username}")
    Users getUser(String username);

    @Select("SELECT userid FROM USERS WHERE username = #{username}")
    int getUserId(String username);

    @Update("UPDATE USERS SET password = #{password}, firstname = #{firstname}, lastname = #{lastname} WHERE username = #{username}")
    void updateUser(String username);

    @Delete("DELETE FROM USERS WHERE username = #{username}")
    void deleteUser(String username);

}

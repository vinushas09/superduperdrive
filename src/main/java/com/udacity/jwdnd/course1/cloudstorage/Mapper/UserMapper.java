package com.udacity.jwdnd.course1.cloudstorage.Mapper;

import com.udacity.jwdnd.course1.cloudstorage.Model.Notes;
import com.udacity.jwdnd.course1.cloudstorage.Model.Users;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO USERS (username, salt, password, firstname, lastname) VALUES(#{username}, #{salt}, #{password}, #{firstName}, #{lastName})")
    @Options(useGeneratedKeys = true, keyProperty = "userid")
    int insertUser(Users users);

    @Select("SELECT * FROM USERS WHERE username = #{username}")
    Users getUser(String username);

    @Update("UPDATE USERS SET password = #{password}, firstname = #{firstname}, lastname = #{lastname} WHERE username = #{username}")
    void updateUser(Notes notes);

    @Delete("DELETE FROM USERS WHERE username = #{username}")
    void deleteUser(String username);

}

package com.udacity.jwdnd.course1.cloudstorage.Mapper;

import com.udacity.jwdnd.course1.cloudstorage.Entity.Credentials;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CredentialsMapper {

    @Insert("INSERT INTO CREDENTIALS (url, username, key, password, userid) VALUES(#{url}, #{username}, #{key}, #{password}, #{userid})")
    @Options(useGeneratedKeys = true, keyProperty = "credentialid")
    int insertCredentials(Credentials credentials);

    @Select("SELECT * FROM CREDENTIALS WHERE credentialid = #{credentialid}")
    Credentials getCredentials(int credentialid);

    @Select("SELECT key FROM CREDENTIALS WHERE credentialid = #{credentialid}")
    String getKey(int credentialid);

    @Update("UPDATE CREDENTIALS SET url = #{url}, username = #{username}, password = #{password} WHERE credentialid = #{credentialid}")
    void updateCredentials(Credentials credentialid);

    @Delete("DELETE FROM CREDENTIALS WHERE username = #{username}")
    void deleteCredentials(String username);
}

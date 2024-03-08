package com.udacity.jwdnd.course1.cloudstorage.Mapper;

import com.udacity.jwdnd.course1.cloudstorage.Entity.Files;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FilesMapper {

    @Insert("INSERT INTO FILES (filename, contenttype,filesize,userid,filedata) VALUES(#{filename}, #{contenttype},#{filesize}, #{userid}, #{filedata})")
    @Options(useGeneratedKeys = true, keyProperty = "fileid")
    Integer insertFiles(Files files);

    @Select("SELECT * FROM Files WHERE filename = #{filename}")
    Files getFiles(String filename);

    @Select("SELECT * FROM Files WHERE fileid = #{fileid}")
    Files getFile(Integer fileid);

    @Select("SELECT filename FROM Files WHERE userid = #{userid}")
    List<String> getUserFiles(Integer userid);

//    @Update("UPDATE FILES SET filename = #{filename} WHERE filename = #{filename}")
//    void updateFiles(Files files);

    @Delete("DELETE FROM FILES WHERE fileid = #{fileid}")
    void deleteFile(Integer fileid);

}

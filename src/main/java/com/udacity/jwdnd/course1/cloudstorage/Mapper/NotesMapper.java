package com.udacity.jwdnd.course1.cloudstorage.Mapper;

import com.udacity.jwdnd.course1.cloudstorage.Model.Notes;
import com.udacity.jwdnd.course1.cloudstorage.Model.Users;
import org.apache.ibatis.annotations.*;

@Mapper
public interface NotesMapper {

    @Insert("INSERT INTO NOTES (notetitle, notedescription,userid) VALUES(#{notetitle}, #{notedescription},#{userid})")
    @Options(useGeneratedKeys = true, keyProperty = "noteid")
    int insertNotes(Notes note);

    @Select("SELECT * FROM NOTES WHERE userid = #{userid}")
    Notes getNotes(int userid);

    @Update("UPDATE NOTES SET notetitle = #{notetitle} , notedescription = #{notedescription} WHERE userid = #{userid}")
    void updateNotes(String notetitle);

    @Delete("DELETE FROM NOTES WHERE noteid = #{noteid}")
    void deleteNote(int noteid);
}

package com.udacity.jwdnd.course1.cloudstorage.Mapper;

import com.udacity.jwdnd.course1.cloudstorage.Entity.Notes;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NotesMapper {

    @Insert("INSERT INTO NOTES (notetitle, notedescription,userid) VALUES(#{notetitle}, #{notedescription},#{userid})")
    @Options(useGeneratedKeys = true, keyProperty = "noteid")
    Integer insertNotes(Notes note);

    @Select("SELECT * FROM NOTES WHERE userid = #{userid}")
    List<Notes> getNotes(Integer userid);

    @Update("UPDATE NOTES SET noteid = #{noteid} , notetitle = #{notetitle} , notedescription = #{notedescription} WHERE userid = #{userid}")
    void updateNotes(Notes notes);

    @Delete("DELETE FROM NOTES WHERE noteid = #{noteid}")
    void deleteNote(int noteid);
}

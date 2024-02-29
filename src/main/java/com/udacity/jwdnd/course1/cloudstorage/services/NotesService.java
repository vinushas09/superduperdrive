package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.Mapper.NotesMapper;
import com.udacity.jwdnd.course1.cloudstorage.Model.Notes;
import org.springframework.stereotype.Service;

@Service
public class NotesService {

    private NotesMapper notesMapper;

    public NotesService(NotesMapper notesMapper){
        this.notesMapper = notesMapper;
    }

    // create new notes
    public int createNotes(Notes note){
        return notesMapper.insertNotes(note);
    }

    // view notes
    public Notes viewNotes(int userid){
        return notesMapper.getNotes(userid);
    }

    //edit notes
    public void editNotes(String noteTitle){
         notesMapper.updateNotes(noteTitle);
    }

    //delete notes
    public void deleteNotes(int noteid){
        notesMapper.deleteNote(noteid);
    }
}

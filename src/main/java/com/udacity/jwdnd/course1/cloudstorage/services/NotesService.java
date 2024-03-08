package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.Entity.Notes;
import com.udacity.jwdnd.course1.cloudstorage.Mapper.NotesMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotesService {

    private NotesMapper notesMapper;
    private UserService userService;
    public NotesService(NotesMapper notesMapper,UserService userService){

        this.notesMapper = notesMapper;
        this.userService = userService;
    }

    // create new notes
    public int createNotes(Notes note){
        Integer userid = userService.getCurrentUser();
        Notes newNote = new Notes(null,note.getNotetitle(),note.getNotedescription(),userid);
        return notesMapper.insertNotes(newNote);
    }

    // view notes
    public List<Notes> viewNotes(int userid){
        return notesMapper.getNotes(userid);
    }

    //edit notes
    public void editNotes(Notes notes){
        Integer userid = userService.getCurrentUser();
        Notes updatedNotes = notes;
        updatedNotes.setNotetitle(notes.getNotetitle());
        updatedNotes.setNotedescription(notes.getNotedescription());
        updatedNotes.setUserid(userid);
        notesMapper.updateNotes(updatedNotes);
    }

    //delete notes
    public void deleteNotes(int noteid){
        notesMapper.deleteNote(noteid);
    }
}

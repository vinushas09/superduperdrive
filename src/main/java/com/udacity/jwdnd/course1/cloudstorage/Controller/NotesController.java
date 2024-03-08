package com.udacity.jwdnd.course1.cloudstorage.Controller;


import com.udacity.jwdnd.course1.cloudstorage.Entity.Notes;
import com.udacity.jwdnd.course1.cloudstorage.Entity.Users;
import com.udacity.jwdnd.course1.cloudstorage.services.NotesService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/notes")
public class NotesController {

    private NotesService notesService;

    public NotesController(NotesService notesService,UserService userService){
        this.notesService = notesService;
    }

    @GetMapping
    public String notesPage(){
        return "home";
    }

    @PostMapping("/createNote")
    public String createNotes(@ModelAttribute("notes") Notes notes , Model model){
        if(notes.getNoteid() == null){
           notesService.createNotes(notes);
        }
        model.addAttribute("newnotes", "created successfully");
        return "home";
    }

    @PutMapping("/editNote")
    public String editNotes(@ModelAttribute Notes note,Model model){
        notesService.editNotes(note);
        model.addAttribute("notestitle", "notes updated successfully ");
        return "home";
    }

    @DeleteMapping("/deleteNote/{noteid}")
    public String deleteNotes(@PathVariable int noteid, Model model){
        notesService.deleteNotes(noteid);
        model.addAttribute("noteid", "successfully deleted");
        return "home";
    }
}

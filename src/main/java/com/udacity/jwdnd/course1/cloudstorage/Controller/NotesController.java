package com.udacity.jwdnd.course1.cloudstorage.Controller;

import com.udacity.jwdnd.course1.cloudstorage.Model.Notes;
import com.udacity.jwdnd.course1.cloudstorage.Model.Users;
import com.udacity.jwdnd.course1.cloudstorage.services.NotesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("notes")
public class NotesController {

    private NotesService notesService;
    private Users users;

    public NotesController(NotesService notesService, Users users){
        this.notesService = notesService;
        this.users = users;
    }

    @GetMapping
    public String notesPage(){
        return "home";
    }

//    @PostMapping("/createNotes")
//    public String createNotes(@RequestParam("notetitle") String notetitle,@RequestParam("notedescription") String noteDescription ,Model model){
//        Notes newNote = new Notes(null,notetitle,noteDescription, users.getUserid());
//        notesService.createNotes(newNote);
//        model.addAttribute("notes", true);
//        return "home";
//    }

    @PostMapping("/createNotes")
    public String createNotes(@RequestParam("notes") Notes notes , Model model){
        notesService.createNotes(notes);
        model.addAttribute("notes", true);
        return "home";
    }

    @PutMapping("/editNotes")
    public String editNotes(@RequestParam("notestitle") String notesTitle, Model model){
        notesService.editNotes(notesTitle);
        model.addAttribute("notestitle", "notes updated successfully ");
        return "home";
    }

    @DeleteMapping("/deleteNotes/{noteid}")
    public String deleteNotes(@PathVariable int noteid, Model model){
        notesService.deleteNotes(noteid);
        model.addAttribute("noteid", "successfully deleted");
        return "home";
    }
}

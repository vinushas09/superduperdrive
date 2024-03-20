package com.udacity.jwdnd.course1.cloudstorage.Controller;

import com.udacity.jwdnd.course1.cloudstorage.Entity.Credentials;
import com.udacity.jwdnd.course1.cloudstorage.Entity.Files;
import com.udacity.jwdnd.course1.cloudstorage.Entity.Notes;
import com.udacity.jwdnd.course1.cloudstorage.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {

    private FileService fileService;
    private NotesService notesService;
    private CredentialsService credentialsService;
    private UserService userService;
    private EncryptionService encryptionService;


    public HomeController(FileService fileService, NotesService notesService,CredentialsService credentialsService,UserService userService, EncryptionService encryptionService){
        this.fileService = fileService;
        this.notesService = notesService;
        this.credentialsService = credentialsService;
        this.userService = userService;
        this.encryptionService = encryptionService;
    }

    @GetMapping()
    public String getHomePage(Model model){
        Integer userid = userService.getCurrentUser();

        List<Files> files = fileService.viewFiles(userid);
        model.addAttribute("files", files);

        List<Notes> notes = notesService.viewNotes(userid);
        model.addAttribute("notes",notes);

        List<Credentials> credentials = credentialsService.getCredentialsOfUser(userid);
        model.addAttribute("credentials", credentials);

        Notes note = new Notes(userid, "notetitle", "notedescription");
        model.addAttribute("newNote", note);
        Credentials credential = new Credentials();
        model.addAttribute("newCredential", credential);
        model.addAttribute("encryptionService", encryptionService);
        return "home";
    }
}

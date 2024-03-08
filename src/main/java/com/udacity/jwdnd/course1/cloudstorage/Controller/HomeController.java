package com.udacity.jwdnd.course1.cloudstorage.Controller;

import com.udacity.jwdnd.course1.cloudstorage.Entity.Credentials;
import com.udacity.jwdnd.course1.cloudstorage.Entity.Notes;
import com.udacity.jwdnd.course1.cloudstorage.services.CredentialsService;
import com.udacity.jwdnd.course1.cloudstorage.services.FileService;
import com.udacity.jwdnd.course1.cloudstorage.services.NotesService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
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

    public HomeController(FileService fileService, NotesService notesService,CredentialsService credentialsService,UserService userService){
        this.fileService = fileService;
        this.notesService = notesService;
        this.credentialsService = credentialsService;
        this.userService = userService;
    }

    @GetMapping()
    public String getHomePage(Model model){
        Integer userid = userService.getCurrentUser();

        List<String> files = fileService.viewFiles(userid);
        model.addAttribute("files", files);

        List<Notes> notes = notesService.viewNotes(userid);
        model.addAttribute("notes",notes);

        List<Credentials> credentials = credentialsService.getCredentialsOfUser(userid);
        model.addAttribute("credentials", credentials);

        Notes note = new Notes(null, "Title", "Description");
        model.addAttribute("newNote", note);
        Credentials credential = new Credentials();
        model.addAttribute("newCredential", credential);

        return "home";
    }
}

package com.udacity.jwdnd.course1.cloudstorage.Controller;

import com.udacity.jwdnd.course1.cloudstorage.Entity.Credentials;
import com.udacity.jwdnd.course1.cloudstorage.services.CredentialsService;
import com.udacity.jwdnd.course1.cloudstorage.services.EncryptionService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/credentails")
public class CredentialsController {

    private CredentialsService credentialsService;
    private EncryptionService encryptionService;
    private UserService userService;

    public CredentialsController(CredentialsService credentialsService, EncryptionService encryptionService,UserService userService){
        this.credentialsService = credentialsService;
        this.encryptionService = encryptionService;
    }

    @GetMapping
    public String getCredentialsPage(){
        return "home";
    }

    @PostMapping("/addCredentails")
    public String addCredentails(Credentials credentials, Model model){
        if(credentials.getCredentialid() == null){
            credentialsService.createCredentials(credentials);
        } else {
            credentialsService.editCredentials(credentials);
        }
        model.addAttribute("credentials", "added successfully");
        return "home";
    }

    @GetMapping("/viewCredentials/{id}")
    public String viewCredentials(@PathVariable int credentialid, Model model){
        credentialsService.viewCredentials(credentialid);
        model.addAttribute("credentials","successfully updated");
        return "home";
    }

    @DeleteMapping("/deleteCredentials/{name}")
    public String deleteCredentials(@PathVariable String name, Model model){
        credentialsService.deleteNotes(name);
        model.addAttribute("deleteCredential", "successfully deleted");
        return "home";
    }
}

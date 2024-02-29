package com.udacity.jwdnd.course1.cloudstorage.Controller;

import com.udacity.jwdnd.course1.cloudstorage.Model.Credentials;
import com.udacity.jwdnd.course1.cloudstorage.services.CredentialsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/credentails")
public class CredentialsController {

    private CredentialsService credentialsService;

    public CredentialsController(CredentialsService credentialsService){
        this.credentialsService = credentialsService;
    }

    @GetMapping
    public String getCredentialsPage(){
        return "home";
    }

    @PostMapping("/storeCredentails")
    public String storeCredentails(@RequestParam Credentials credentials, Model model){
        int credentialsAdded = credentialsService.createCredentials(credentials);
        model.addAttribute("credentials", "added successfully");
        return "home";
    }

    @GetMapping("/viewCredentials/{id}")
    public String viewCredentials(@PathVariable int credentialid, Model model){
        model.addAttribute("credentials",credentialsService.viewCredentials(credentialid));
        return "home";
    }

    @PutMapping("/editCredentials/{id}")
    public String updateCredentials(@PathVariable int credentialid, Model model){
        credentialsService.editCredentials(credentialid);
        model.addAttribute("credentials","updated");
        return "home";
    }

    @DeleteMapping("/deleteCredentials/{name}")
    public String deleteCredentials(@PathVariable String name, Model model){
        credentialsService.deleteNotes(name);
        model.addAttribute("deleteCredential", "successfully deleted");

        return "home";
    }
}

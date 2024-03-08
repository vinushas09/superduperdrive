package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.Entity.Credentials;
import com.udacity.jwdnd.course1.cloudstorage.Mapper.CredentialsMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CredentialsService {

    private CredentialsMapper credentialsMapper;
    private EncryptionService encryptionService;
    private UserService userService;

    public CredentialsService(CredentialsMapper credentialsMapper,EncryptionService encryptionService,UserService userService){
        this.credentialsMapper = credentialsMapper;
        this.userService = userService;
        this.encryptionService = encryptionService;
    }

    // create credentials
    public int createCredentials(Credentials credentials){
        int userid = userService.getCurrentUser();
        String key = encryptionService.getKey();
        credentials.setUrl(credentials.getUrl());
        credentials.setUsername(credentials.getUsername());
        credentials.setKey(key);
        credentials.setPassword(encryptionService.encryptValue(credentials.getPassword(),key));
        credentials.setUserid(userid);
        return credentialsMapper.insertCredentials(credentials);
    }

    // view credentials
    public Credentials getCredentials(int credentialid){
        return credentialsMapper.getCredentials(credentialid);
    }

    public List<Credentials> getCredentialsOfUser(Integer userid){
        return credentialsMapper.getCredentialsOfUser(userid);
    }


    //get key
    public String getCredentialKey(int credentialid){
        return credentialsMapper.getKey(credentialid);
    }
    //edit credentials
    public void editCredentials(Credentials credentials){
        Credentials updatedCredentials = credentials;
        String key = encryptionService.getKey();
        updatedCredentials.setUrl(credentials.getUrl());
        updatedCredentials.setUsername(credentials.getUsername());
        updatedCredentials.setKey(key);
        updatedCredentials.setPassword(encryptionService.encryptValue(credentials.getPassword(),key));
        credentialsMapper.updateCredentials(updatedCredentials);
    }

    //delete credentials
    public void deleteNotes(Integer credentialid){
        credentialsMapper.deleteCredentials(credentialid);
    }
}

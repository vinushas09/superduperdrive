package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.Mapper.CredentialsMapper;
import com.udacity.jwdnd.course1.cloudstorage.Model.Credentials;
import org.springframework.stereotype.Service;

@Service
public class CredentialsService {

    private CredentialsMapper credentialsMapper;

    public CredentialsService(CredentialsMapper credentialsMapper){
        this.credentialsMapper = credentialsMapper;
    }

    // create credentials
    public int createCredentials(Credentials credentials){
        return credentialsMapper.insertCredentials(credentials);
    }

    // view credentials
    public Credentials viewCredentials(int credentialid){
        return credentialsMapper.getCredentials(credentialid);
    }

    //edit credentials
    public void editCredentials(int credentialid){
        credentialsMapper.updateCredentials(credentialid);
    }

    //delete credentials
    public void deleteNotes(String userName){

        credentialsMapper.deleteCredentials(userName);
    }
}

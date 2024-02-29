package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.Mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.Model.Users;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;

@Service
public class UserService {

    private UserMapper userMapper;
    private HashService hashService;

    public UserService(UserMapper userMapper, HashService hashService){
        this.userMapper = userMapper;
        this.hashService = hashService;
    }

    //create new user
    public int createUser(Users user){
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        String encodedSalt = Base64.getEncoder().encodeToString(salt);
        String hashedPassword = hashService.getHashedValue(user.getPassword(), encodedSalt);
        return userMapper.insertUser(new Users(null, user.getUsername(), encodedSalt, hashedPassword, user.getFirstname(), user.getLastname()));
    }

    public boolean checkUserAlreadyExists(String username){
        if(userMapper.getUser(username).equals(username)){
            return false;
        }
        return true;
    }

    //login, verify credentials can be done in spring security class
//    public boolean verifyLoginCredentials(String username, String password){
//        if(userMapper.getUser(username).equals(username) && userMapper.getUser(password).equals(password)){
//            return true;
//        }
//        return false;
//    }
}

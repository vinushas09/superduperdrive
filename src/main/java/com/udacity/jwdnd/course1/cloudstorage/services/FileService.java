package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.Mapper.FilesMapper;
import com.udacity.jwdnd.course1.cloudstorage.Model.Files;
import com.udacity.jwdnd.course1.cloudstorage.Model.Users;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileService {

    private FilesMapper filesMapper;
    private Users users;

    public FileService(FilesMapper filesMapper, Users users){

        this.filesMapper = filesMapper;
        this.users = users;
    }

    // upload file
    public int uploadFiles(MultipartFile file) throws IOException {
        Files newFile = new Files(null, file.getOriginalFilename(), file.getContentType(), file.getSize(),users.getUserid(), file.getBytes());
        return filesMapper.insertFiles(newFile);
    }

    // view file
    public List<Files> viewFiles(int userid){
        return filesMapper.getUserFiles(userid);
    }

    public Files downloadFiles(String filename){
        return filesMapper.getFiles(filename);
    }

    //delete file
    public void deleteFile(String fileName){
         filesMapper.deleteFile(fileName);
    }

    //check if the file already exists

    public boolean checkFileExists(String fileName){
        if (filesMapper.getFiles(fileName) != null){
            return true;
        } else {
            return false;
        }
    }
}

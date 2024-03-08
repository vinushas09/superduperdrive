package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.Entity.Files;
import com.udacity.jwdnd.course1.cloudstorage.Entity.Users;
import com.udacity.jwdnd.course1.cloudstorage.Mapper.FilesMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class FileService {

    private FilesMapper filesMapper;
    private UserService userService;
    public FileService(FilesMapper filesMapper,UserService userService){
        this.filesMapper = filesMapper;
        this.userService = userService;
    }

    // upload file
    public int uploadFiles(MultipartFile file) throws IOException {
        Integer userid = userService.getCurrentUser();
        Files newFile = new Files(null, file.getOriginalFilename(), file.getContentType(), file.getSize(),userid, file.getBytes());
        return filesMapper.insertFiles(newFile);
    }

    // view file
    public List<String> viewFiles(Integer userid){
        return filesMapper.getUserFiles(userid);
    }

    public Files getFile(Integer fileid){
        return filesMapper.getFile(fileid);
    }

    //delete file
    public void deleteFile(Integer fileid){
         filesMapper.deleteFile(fileid);
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

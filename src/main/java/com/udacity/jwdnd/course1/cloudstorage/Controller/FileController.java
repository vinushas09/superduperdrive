package com.udacity.jwdnd.course1.cloudstorage.Controller;

import com.udacity.jwdnd.course1.cloudstorage.Entity.Files;
import com.udacity.jwdnd.course1.cloudstorage.services.FileService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/files")
public class FileController {

    FileService fileService;

    public FileController(FileService fileService){
        this.fileService = fileService;
    }

    @GetMapping
    public String notesPage(){
        return "home";
    }

    @PostMapping("/uploadFiles")
    public String uploadFile(@RequestParam("fileUpload") MultipartFile file, Model model) throws IOException {
        try {
            if (!fileService.checkFileExists(file.getOriginalFilename())) {
                fileService.uploadFiles(file);
                model.addAttribute("fileUploadedSuccessfully", true);
            } else {
                model.addAttribute("errorMessage","File cannot be uploaded");
            }
        }catch(IOException ioException){
            ioException.printStackTrace();
        }
        return "home";
    }

    @GetMapping("/viewFile/{fileid}")
    public ResponseEntity<Resource> viewFile(@PathVariable Integer fileid, Model model){
        Files file = fileService.getFile(fileid);
        return  ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(file.getContenttype()))
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename=\""+file.getFilename()+"\"")
                .body(new ByteArrayResource(file.getFiledata()));
    }


    @DeleteMapping("/deleteFile/{name}")
    public String deleteFiles(@PathVariable Integer fileid, Model model){
        fileService.deleteFile(fileid);
        model.addAttribute("deletedFile", true);
        return "home";
    }
}

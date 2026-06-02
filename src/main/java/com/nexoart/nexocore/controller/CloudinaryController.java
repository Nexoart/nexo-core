package com.nexoart.nexocore.controller;


import com.nexoart.nexocore.service.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
public class CloudinaryController {

    @Autowired
    private CloudinaryService cloudinaryService;

    @PostMapping
    //ResquestParam(file) recebe o arquivo enviado
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file){
        try{
            String url = cloudinaryService.uploadFile(file);
            return ResponseEntity.ok(url);
        } catch (Exception e) {
            e.printStackTrace(); // ISSO AQUI FAZ O ERRO APARECER EM VERMELHO NO CONSOLE!
            return ResponseEntity.status(500).body("Erro no upload");
        }
    }

}

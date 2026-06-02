package com.nexoart.nexocore.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryService {
    @Autowired
    private Cloudinary cloudinary;

    //IOException = É uma exceção (erro) relacionada a entrada/saida de dados.
    // Exemplo: pode dar erro caso o arquivo esteja corrompido, der problema ao ler os dados do arquivo ou dar falha ao transferir ela.
    public String uploadFile(MultipartFile file) throws IOException {

        //Aqui faz com que a função cloudinary faça o envio do arquivo e salva lá na nuvem.
        Map uploadResult = cloudinary.uploader().upload(
                file.getBytes(),
                ObjectUtils.emptyMap()
        );
        //Aqui ele me retorna o Secury_url, que é o link da imagem em HTTPS
        return uploadResult.get("secure_url").toString();
    }
}

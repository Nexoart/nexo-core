// aqui é pra configurar o Cloudinary
// site para acessar:https://cloudinary.com


package com.nexoart.nexocore.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinary(){
    return new Cloudinary(ObjectUtils.asMap(
    "cloud_name", "....", // coloque o seu name que existe no site da Cloudinary
    "api_key","...", //coloque a key da api
    "api_secret", "..." // coloque a key da api secret que estará disponivel no site
    ));
}
}

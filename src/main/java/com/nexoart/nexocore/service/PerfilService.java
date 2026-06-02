package com.nexoart.nexocore.service;

import com.nexoart.nexocore.dto.UpdateperfilDTO;
import com.nexoart.nexocore.entity.User;
import com.nexoart.nexocore.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfilService {

    @Autowired
    private UserRepository userRepository;

    public User updatePerfil(String email, UpdateperfilDTO dto) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        user.setBio(dto.getBio());
        user.setAlias(dto.getAlias());
        user.setProfileImage(dto.getProfileImage());
        user.setInstagram(dto.getInstagram());
        user.setLinkedin(dto.getLinkedin());
        user.setGithub(dto.getGithub());
        user.setWebsite(dto.getWebsite());

        return userRepository.save(user);
    }
}
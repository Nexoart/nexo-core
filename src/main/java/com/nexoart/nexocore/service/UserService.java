package com.nexoart.nexocore.service;

// O IMPORT CORRETO É ESTE AQUI :

import com.nexoart.nexocore.entity.User;
import com.nexoart.nexocore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User saveUser(User user) {
        // Essa sintaxe vai criptografar antes de salvar:
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User buscarPorId(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public User atualizarPerfil(Long id, User dadosAtualizados) {
        User user = buscarPorId(id);
        if (dadosAtualizados.getName() != null) user.setName(dadosAtualizados.getName());
        if (dadosAtualizados.getBio() != null) user.setBio(dadosAtualizados.getBio());
        if (dadosAtualizados.getProfileImage() != null) user.setProfileImage(dadosAtualizados.getProfileImage());
        if (dadosAtualizados.getWebsite() != null) user.setWebsite(dadosAtualizados.getWebsite());
        if (dadosAtualizados.getCoverImage() != null) user.setCoverImage(dadosAtualizados.getCoverImage());
        return userRepository.save(user);
    }
}



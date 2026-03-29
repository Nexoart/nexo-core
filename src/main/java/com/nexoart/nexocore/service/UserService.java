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

}



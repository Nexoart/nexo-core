package com.nexoart.nexocore.controller;

import com.nexoart.nexocore.dto.*;
import com.nexoart.nexocore.entity.User;
import com.nexoart.nexocore.repository.UserRepository;
import com.nexoart.nexocore.service.JWTService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JWTService jwtService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDTO dto) {

        if(userRepository.findByEmail(dto.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Email já existe");
        }

        User user = new User();

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setArtista(dto.isArtista());

        userRepository.save(user);

        return ResponseEntity.ok("Usuário criado");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO dto) {

        User user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        boolean passwordMatch = passwordEncoder.matches(
                dto.getPassword(),
                user.getPassword()
        );

        if(!passwordMatch) {
            return ResponseEntity.badRequest().body("Senha inválida");
        }

        String token = jwtService.generateToken(user.getEmail());

        return ResponseEntity.ok(new AuthResponseDTO(token));
    }
}

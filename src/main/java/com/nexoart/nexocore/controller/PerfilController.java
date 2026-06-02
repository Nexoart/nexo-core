package com.nexoart.nexocore.controller;

import com.nexoart.nexocore.dto.PerfilResponseDTO;
import com.nexoart.nexocore.dto.UpdateperfilDTO;
import com.nexoart.nexocore.entity.User;
import com.nexoart.nexocore.service.PerfilService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/perfil")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    @PutMapping
    public ResponseEntity<PerfilResponseDTO> updatePerfil(
            @RequestBody UpdateperfilDTO dto,
            Authentication authentication
    ) {
        String email = authentication.getName();
        User updatedPerfil = perfilService.updatePerfil(email, dto);
        return ResponseEntity.ok(new PerfilResponseDTO(updatedPerfil));
    }
}
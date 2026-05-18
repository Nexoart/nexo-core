package com.nexoart.nexocore.controller;

import com.nexoart.nexocore.entity.User;
import com.nexoart.nexocore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User buscarPorId(@PathVariable Long id) {
        return userService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public User atualizarPerfil(@PathVariable Long id, @RequestBody User user) {
        return userService.atualizarPerfil(id, user);
    }
}

package com.nexoart.nexocore.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    @GetMapping("/ping")
    public String ping() {
        return "Nexo-Core está online e aguardando as artes! 🎨";
    }
}
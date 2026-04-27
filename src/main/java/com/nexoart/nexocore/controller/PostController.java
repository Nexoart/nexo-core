package com.nexoart.nexocore.controller;
import com.nexoart.nexocore.entity.Post;
import com.nexoart.nexocore.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/posts")
@CrossOrigin("*")
public class PostController {

    private final PostService service;

    public PostController(PostService service){
        this.service = service;
    }

    @PostMapping
    public Post criar(@RequestBody Post post){
        return service.salvar(post);
    }

    @GetMapping
    public List<Post> listar(){
       return service.listarTodos();
    }
}

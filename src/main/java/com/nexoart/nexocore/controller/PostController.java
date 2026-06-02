package com.nexoart.nexocore.controller;
import com.nexoart.nexocore.entity.Post;
import com.nexoart.nexocore.entity.Comentario;
import com.nexoart.nexocore.service.PostService;
import org.springframework.http.ResponseEntity;
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
    public Post criar(@RequestParam Long userId, @RequestBody Post post){
        return service.salvar(post, userId);
    }

    @GetMapping
    public List<Post> listar(){
       return service.listarTodos();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {

        service.deletar(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/like")
    public Post darLike(@PathVariable Long id) {
        return service.darLike(id);
    }

    @PostMapping("/{id}/comments")
    public Post adicionarComentario(@PathVariable Long id, @RequestBody Comentario comentario) {
        return service.adicionarComentario(id, comentario);
    }
}

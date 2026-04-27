package com.nexoart.nexocore.service;
import com.nexoart.nexocore.entity.Post;
import com.nexoart.nexocore.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {
    private final PostRepository repository;

    public PostService(PostRepository repository){
        this.repository = repository;
    }
    public Post salvar(Post post){
        post.setTimestamp(LocalDateTime.now());
        return repository.save(post);
    }
    public List<Post> listarTodos(){
        return repository.findAll();
    }
}

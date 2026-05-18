package com.nexoart.nexocore.service;
import com.nexoart.nexocore.entity.Post;
import com.nexoart.nexocore.entity.Comentario;
import com.nexoart.nexocore.repository.PostRepository;
import com.nexoart.nexocore.repository.UserRepository;
import com.nexoart.nexocore.entity.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {
    private final PostRepository repository;
    private final UserRepository userRepository;

    public PostService(PostRepository repository, UserRepository userRepository){
        this.repository = repository;
        this.userRepository = userRepository;
    }
    
    public Post salvar(Post post, Long userId){
        User artista = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        post.setArtista(artista);
        post.setTimestamp(LocalDateTime.now());
        return repository.save(post);
    }
    public List<Post> listarTodos(){
        return repository.findAll();
    }
    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public Post darLike(Long id) {
        Post post = repository.findById(id).orElseThrow(() -> new RuntimeException("Post não encontrado"));
        post.setLikesCount(post.getLikesCount() + 1);
        return repository.save(post);
    }

    public Post adicionarComentario(Long postId, Comentario comentario) {
        Post post = repository.findById(postId).orElseThrow(() -> new RuntimeException("Post não encontrado"));
        comentario.setPost(post);
        post.getComentarios().add(comentario);
        return repository.save(post);
    }
}

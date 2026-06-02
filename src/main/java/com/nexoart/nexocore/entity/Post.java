package com.nexoart.nexocore.entity;

import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;

import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
public class Post {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User artista;

    private String urlImagem;
private String descricao;
private LocalDateTime timestamp;
private int likesCount = 0;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comentario> comentarios = new ArrayList<>();
public Post(){
}

    public Long getId() {
        return id;
    }

    public User getArtista() {
        return artista;
    }

    public void setArtista(User artista) {
        this.artista = artista;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
}

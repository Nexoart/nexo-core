package com.nexoart.nexocore.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    private  String alias; //Nome de usuário

    //getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getAlias() { return alias; }
    public void setAlias(String alias) { this.alias = alias; }
}
package com.nexoart.nexocore.dto;

import com.nexoart.nexocore.entity.User;

public class PerfilResponseDTO {

    private Long id;
    private String name;
    private String email;
    private String bio;
    private String alias;
    private String profileImage;
    private String instagram;
    private String linkedin;
    private String github;
    private String website;

    public PerfilResponseDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.bio = user.getBio();
        this.alias = user.getAlias();
        this.profileImage = user.getProfileImage();
        this.instagram = user.getInstagram();
        this.linkedin = user.getLinkedin();
        this.github = user.getGithub();
        this.website = user.getWebsite();
    }

    // Getters
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getBio() { return bio; }
    public String getAlias() { return alias; }
    public String getProfileImage() { return profileImage; }
    public String getInstagram() { return instagram; }
    public String getLinkedin() { return linkedin; }
    public String getGithub() { return github; }
    public String getWebsite() { return website; }
}
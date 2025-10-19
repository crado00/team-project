package com.example.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "users")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String FullName;

    @Column(unique = true, nullable = false)
    private String Username;

    @Column(unique = true, nullable = false)
    private String Email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String ResidentialArea;

    @Column(nullable = true)
    private String SelfIntroduction;

    @Column(nullable = true)
    private String profileImageUrl;

}

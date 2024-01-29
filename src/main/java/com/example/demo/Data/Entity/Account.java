package com.example.demo.Data.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
@Entity
@Table(name = "account")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private int role;


    @Column(name = "created_at", updatable = false)
    private Date createdAt;


    @Column(name = "update_at")
    private Date updatedAt;
}

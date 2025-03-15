package com.example.blogservice.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    
    @Column(columnDefinition = "TEXT")
    private String content;
    
    private String author;
    
    private LocalDateTime createdAt = LocalDateTime.now();

    // Getters and Setters
}
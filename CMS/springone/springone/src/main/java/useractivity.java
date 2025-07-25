package com.example.cms.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class UserActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userId;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    private LocalDateTime viewedAt;

    // Constructors
    public UserActivity() {}

    public UserActivity(String userId, Article article) {
        this.userId = userId;
        this.article = article;
        this.viewedAt = LocalDateTime.now();
    }

    // Getters and Setters
    // (Omitted for brevity - include all fields)
}
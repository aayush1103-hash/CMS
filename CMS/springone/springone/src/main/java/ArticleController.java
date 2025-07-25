package com.example.cms.controller;

import com.example.cms.model.Article;
import com.example.cms.service.ArticleService;
import com.example.cms.service.UserActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {
    private final ArticleService articleService;
    private final UserActivityService userActivityService;

    @Autowired
    public ArticleController(ArticleService articleService, UserActivityService userActivityService) {
        this.articleService = articleService;
        this.userActivityService = userActivityService;
    }

    @PostMapping
    public Article createArticle(@RequestBody Article article) {
        return articleService.createArticle(article);
    }

    @GetMapping
    public List<Article> getAllArticles() {
        return articleService.getAllArticles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticleById(
            @PathVariable Long id,
            @RequestHeader("X-User-Id") String userId) {

        return articleService.getArticleById(id)
                .map(article -> {
                    userActivityService.recordArticleView(userId, article);
                    return ResponseEntity.ok(article);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Article> updateArticle(
            @PathVariable Long id,
            @RequestBody Article updatedArticle) {

        return ResponseEntity.ok(articleService.updateArticle(id, updatedArticle));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
        return ResponseEntity.noContent().build();
    }
}
package com.example.cms.service;

import com.example.cms.model.Article;
import com.example.cms.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Article createArticle(Article article) {
        return articleRepository.save(article);
    }

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public Optional<Article> getArticleById(Long id) {
        return articleRepository.findById(id);
    }

    public Article updateArticle(Long id, Article updatedArticle) {
        return articleRepository.findById(id)
                .map(article -> {
                    article.setTitle(updatedArticle.getTitle());
                    article.setContent(updatedArticle.getContent());
                    article.setUpdatedAt(LocalDateTime.now());
                    return articleRepository.save(article);
                })
                .orElseGet(() -> {
                    updatedArticle.setId(id);
                    return articleRepository.save(updatedArticle);
                });
    }

    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }
}
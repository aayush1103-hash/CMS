package com.example.cms.service;

import com.example.cms.model.Article;
import com.example.cms.model.UserActivity;
import com.example.cms.repository.UserActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserActivityService {
    private final UserActivityRepository userActivityRepository;

    @Autowired
    public UserActivityService(UserActivityRepository userActivityRepository) {
        this.userActivityRepository = userActivityRepository;
    }

    public void recordArticleView(String userId, Article article) {
        UserActivity activity = new UserActivity(userId, article);
        userActivityRepository.save(activity);
    }

    public List<UserActivity> getRecentViews(String userId) {
        return userActivityRepository.findRecentViewsByUser(userId);
    }
}
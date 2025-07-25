package com.example.cms.controller;

import com.example.cms.model.UserActivity;
import com.example.cms.service.UserActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user-activity")
public class UserActivityController {
    private final UserActivityService userActivityService;

    @Autowired
    public UserActivityController(UserActivityService userActivityService) {
        this.userActivityService = userActivityService;
    }

    @GetMapping("/recent-views")
    public List<UserActivity> getRecentViews(
            @RequestHeader("X-User-Id") String userId) {

        return userActivityService.getRecentViews(userId);
    }
}
package com.example.cms.repository;

import com.example.cms.model.UserActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserActivityRepository extends JpaRepository<UserActivity, Long> {
    @Query("SELECT u FROM UserActivity u WHERE u.userId = :userId ORDER BY u.viewedAt DESC")
    List<UserActivity> findRecentViewsByUser(@Param("userId") String userId);
}
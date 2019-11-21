/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soaproject.repository;

import com.soaproject.bean.App;
import com.soaproject.bean.UserReview;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nthop
 */
@Repository
public class JdbcAppRepository implements AppRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<UserReview> getUserReviews(String appName) {
        return jdbcTemplate.query("select*from user_reviews where app = ?",
                new Object[]{appName},
                (rs, rowNum)
                -> new UserReview(
                        rs.getString("app"),
                        rs.getString("translated_review"),
                        rs.getString("sentiment"),
                        rs.getString("sentiment_polarity"),
                        rs.getString("sentiment_subjectivity")
                ));
    }

    @Override
    public List<App> findAll() {
        return jdbcTemplate.query("select*from app limit 10",
                (rs, rowNum)
                -> new App(getUserReviews(rs.getString("name")),
                        rs.getString("name"),
                        rs.getString("category"),
                        rs.getString("rating"),
                        rs.getInt("reviews"),
                        rs.getString("size"),
                        rs.getString("installs"),
                        rs.getString("type"),
                        rs.getFloat("price"),
                        rs.getString("content_rating"),
                        rs.getString("genres"),
                        rs.getString("last_updated"),
                        rs.getString("current_ver"),
                        rs.getString("android_ver")
                ));
    }

    @Override
    public String findNameById(int id) {
        return jdbcTemplate.queryForObject("select name from app where id=?", new Object[]{id}, String.class);
    }

    @Override
    public List<UserReview> findUserReviewsById(int id) {
        return getUserReviews(jdbcTemplate.queryForObject("select name from app where id=?",
                new Object[]{id},String.class));
    }

}

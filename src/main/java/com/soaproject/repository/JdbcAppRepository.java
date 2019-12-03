/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soaproject.repository;

import com.soaproject.bean.App;
import com.soaproject.bean.Category;
import com.soaproject.bean.UserReview;
import com.soaproject.bean.Type;
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
                -> new App(
                        //getUserReviews(rs.getString("name")),
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
    public List<UserReview> getUserReviewsById(int id) {
        return getUserReviews(jdbcTemplate.queryForObject("select name from app where id=?",
                new Object[]{id}, String.class));
    }

    @Override
    public List<App> findAppByName(String name) {
        return jdbcTemplate.query("select*from app where app like '%?%'", new Object[]{name},
                (rs, rowNum)
                -> new App(
                        //getUserReviews(rs.getString("name")),
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
    public List<App> findAppByCategory(String category) {
        return jdbcTemplate.query("select*from app where category = '?'", new Object[]{category},
                (rs, rowNum)
                -> new App(
                        //getUserReviews(rs.getString("name")),
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
    public List<App> findAppByRating(float rating_start, float rating_end) {
        return jdbcTemplate.query("select*from app where rating between ? and ?", new Object[]{rating_start, rating_end},
                (rs, rowNum)
                -> new App(
                        //getUserReviews(rs.getString("name")),
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
    public List<App> findAppByCountOfReviews(int reviews) {
        return jdbcTemplate.query("select*from app where reviews > ?", new Object[]{reviews},
                (rs, rowNum)
                -> new App(
                        //getUserReviews(rs.getString("name")),
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
    public List<App> findAppByType(String type) {
        return jdbcTemplate.query("select*from app where type = ?", new Object[]{type},
                (rs, rowNum)
                -> new App(
                        //getUserReviews(rs.getString("name")),
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
    public List<App> findAppByMostlyDownloaded(int downloaded) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Category> getAllCategories() {
        return jdbcTemplate.query("select category from app group by category",
                (rs, rowNum)
                -> new Category(rs.getString("category"))
        );
    }
 
    @Override
    public List<Type> getAllTypes() {
            return jdbcTemplate.query("select type from app group by type",
                (rs, rowNum)
                -> new Type(rs.getString("type"))
        );
    }

}

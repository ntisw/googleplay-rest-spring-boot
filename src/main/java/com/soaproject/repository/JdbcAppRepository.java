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
        return jdbcTemplate.query("select*from user_reviews where app = ? and translated_review != 'nan'",
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
                        rs.getInt("id"),
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
    public List<App> findAppsByName(String name) {
        return jdbcTemplate.query("select*from app where name like ? ORDER BY rating ='null' ,reviews DESC,rating DESC", new Object[]{"%" + name + "%"},
                (rs, rowNum)
                -> new App(
                        rs.getInt("id"),
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
    public List<App> findAppsByCategory(String category) {
        return jdbcTemplate.query("select*from app where category = ? ORDER BY rating ='null' ,reviews DESC,rating DESC", new Object[]{category},
                (rs, rowNum)
                -> new App(
                        rs.getInt("id"),
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
    public List<App> findAppsByRating(float start) {
        return jdbcTemplate.query("select*from app where rating >=? and rating <?", new Object[]{start, start + 1},
                (rs, rowNum)
                -> new App(
                        rs.getInt("id"),
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
    public List<App> findAppsByCountOfReviews(int reviews) {
        return jdbcTemplate.query("select*from app where reviews > ?", new Object[]{reviews},
                (rs, rowNum)
                -> new App(
                        rs.getInt("id"),
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
    public List<App> findAppsByType(String type) {
        return jdbcTemplate.query("select*from app where type = ? ORDER BY rating ='null' ,reviews DESC,rating DESC", new Object[]{type},
                (rs, rowNum)
                -> new App(
                        rs.getInt("id"),
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

    @Override
    public List<Category> getAllGenresOfGame() {
        return jdbcTemplate.query("SELECT genres FROM app where category = \"GAME\" group by genres",
                (rs, rowNum)
                -> new Category(rs.getString("genres"))
        );
    }

    @Override
    public List<Type> getAllTypeOfContentRating() {
        return jdbcTemplate.query("SELECT content_rating FROM app group by content_rating",
                (rs, rowNum)
                -> new Type(rs.getString("content_rating"))
        );
    }

    @Override
    public List<App> findGameByGenres(String genres) {
        return jdbcTemplate.query("select*from app where genres = ? and category = \"GAME\" ORDER BY rating ='null' ,reviews DESC,rating DESC", new Object[]{genres},
                (rs, rowNum)
                -> new App(
                        rs.getInt("id"),
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
    public List<App> findAppsByContentRating(String contentRating) {
        return jdbcTemplate.query("select*from app where content_rating like ? ORDER BY rating ='null' ,reviews DESC,rating DESC", new Object[]{contentRating + "%"},
                (rs, rowNum)
                -> new App(
                        rs.getInt("id"),
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
    
    //select * from googleplay.appstore where installs !="0+" order by  length(installs),installs

    @Override
    public List<App> findAppsByMostDownload() {
        return jdbcTemplate.query("select*from app where installs !=\"0+\" ORDER BY length(installs) DESC,installs",
                (rs, rowNum)
                -> new App(
                        rs.getInt("id"),
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
    public List<App> findAppsByMostReview() {
        return jdbcTemplate.query("select*from app ORDER BY rating ='null' ,reviews DESC,rating DESC",
                (rs, rowNum)
                -> new App(
                        rs.getInt("id"),
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
    public List<App> getTopAppsDownload() {
        return jdbcTemplate.query("select*from app where installs !=\"0+\" ORDER BY length(installs) DESC,installs limit 10",
                (rs, rowNum)
                -> new App(
                        rs.getInt("id"),
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
    public List<App> getTopAppsReview() {
        return jdbcTemplate.query("select*from app ORDER BY rating ='null' ,reviews DESC,rating DESC limit 10",
                (rs, rowNum)
                -> new App(
                        rs.getInt("id"),
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
}

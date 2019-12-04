/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soaproject.repository;

import com.soaproject.bean.App;
import com.soaproject.bean.Category;
import com.soaproject.bean.Type;
import com.soaproject.bean.UserReview;
import java.util.List;

/**
 *
 * @author nthop
 */
public interface AppRepository {

    //for page
    //public getDataHomePage();
    public List<Category> getAllCategories();

    public List<Category> getAllGenresOfGame();

    public List<Type> getAllTypes();

    public List<Type> getAllTypeOfContentRating();

    //for find app required
    public List<App> findAppsByName(String name);

    public List<App> findAppsByCategory(String category);

    public List<App> findAppsByRating(float start);

    public List<App> findAppsByCountOfReviews(int count);

    public List<App> findAppsByType(String type);

    public List<App> findAppsByMostDownload();

    public List<App> findAppsByMostReview();

    public List<App> findAll();

    public String findNameById(int id);

    public List<UserReview> getUserReviewsById(int id);

    //optional
    public List<App> findGameByGenres(String genres);

    public List<App> findAppsByContentRating(String contentRating);

    public List<App> getTopAppsDownload();

    public List<App> getTopAppsReview();
    //public List<App> getTopGameFree();
    //public List<App> getTopGamePaid();
    //public List<App> findAppByPrice(int id); //between
}

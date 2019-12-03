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
public interface AppRepository{
    //for page
    //public getDataHomePage();
    public List<Category> getAllCategories();
    public List<Type> getAllTypes();
    //for find app required
    public List<App> findAppsByName(String name);
    public List<App> findAppsByCategory(String category);
    public List<App> findAppsByRating(float rating_start,float rating_end);
    public List<App> findAppsByCountOfReviews(int count);
    public List<App> findAppsByType(String type);
    public List<App> findAppsByMostlyDownloaded(int downloaded);
    public List<App> findAll();
    public String findNameById(int id);
    public List<UserReview> getUserReviewsById(int id);
   
    //optional

    //public List<App> getTopAppFree();
    //public List<App> getTopAppPaid();
    //public List<App> getTopGameFree();
    //public List<App> getTopGamePaid();
    //public List<App> findAppByPrice(int id); //between
}

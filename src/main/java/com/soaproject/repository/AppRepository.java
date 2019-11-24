/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soaproject.repository;

import com.soaproject.bean.App;
import com.soaproject.bean.UserReview;
import java.util.List;

/**
 *
 * @author nthop
 */
public interface AppRepository{
    public List<App> findAll();
    public String findNameById(int id);
    public List<UserReview> findUserReviewsById(int id);
    //public List<App> findAppByCategories(int id);
    //public List<App> findAppByRating(int rating);
    //public List<App> findAppByCountOfReviews(int count);
    //public List<App> findAppByType(String type);
    //public List<App> findAppByDownload(int downloaded);
    //public List<App> findAppByName(String name);
    //public List<App> findAppByPrice(int id);
}

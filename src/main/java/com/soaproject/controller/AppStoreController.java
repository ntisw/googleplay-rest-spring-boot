/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soaproject.controller;

import com.soaproject.bean.App;
import com.soaproject.bean.Category;
import com.soaproject.bean.UserReview;
import com.soaproject.bean.Type;
import com.soaproject.repository.AppRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author nthop
 */
@RestController
public class AppStoreController {

    @Autowired
    private AppRepository appRepository;

    @RequestMapping("/findall")
    @CrossOrigin
    public List<App> findAll() {
        return appRepository.findAll();
    }
    
    @RequestMapping("/get/{id}")
    @CrossOrigin
    public String getNameById(@PathVariable int id) {
        return appRepository.findNameById(id);
    }

    @RequestMapping("/reviews")
    @CrossOrigin
    @ResponseBody
    public List<UserReview> getReviewById(@RequestParam int id) {
        return appRepository.getUserReviewsById(id);
    }
    
    @RequestMapping("/category/all")
    @CrossOrigin
    public List<Category> getCategories() {
        return appRepository.getAllCategories();
    }
    
    
    
    @RequestMapping("/type/all")
    @CrossOrigin
    public List<Type> getTypes() {
        return appRepository.getAllTypes();
    }
    
    @RequestMapping("/content_rating/all")
    @CrossOrigin
    public List<Type> getAllTypesOfContentRating() {
        return appRepository.getAllTypeOfContentRating();
    }
    
    @RequestMapping("/games/genres/all")
    @CrossOrigin
    public List<Category> getAllGenresOfGame() {
        return appRepository.getAllGenresOfGame();
    }
    
    @RequestMapping("/find/apps/name")
    @CrossOrigin
    @ResponseBody
    public List<App> findAppsByName(@RequestParam String name) {
        return appRepository.findAppsByName(name);
    }
    
    @RequestMapping("/find/apps/category")
    @CrossOrigin
    @ResponseBody
    public List<App> findAppsByCategory(@RequestParam String category) {
        return appRepository.findAppsByCategory(category);
    }
    
    @RequestMapping("/find/apps/rating")
    @CrossOrigin
    @ResponseBody
    public List<App> findAppsByCategory(@RequestParam float start) {
        return appRepository.findAppsByRating(start);
    }
    
    @RequestMapping("/find/apps/review")
    @CrossOrigin
    @ResponseBody
    public List<App> findAppsByCategory(@RequestParam int reviews) {
        return appRepository.findAppsByCountOfReviews(reviews);
    }
    
    @RequestMapping("/find/apps/type")
    @CrossOrigin
    @ResponseBody
    public List<App> findAppsByType(@RequestParam String type) {
        return appRepository.findAppsByType(type);
    }
    
    @RequestMapping("/find/apps/games/genres")
    @CrossOrigin
    @ResponseBody
    public List<App> findGamesByGenres(@RequestParam String genres) {
        return appRepository.findGameByGenres(genres);
    }
    
    @RequestMapping("/find/apps/content_rating")
    @CrossOrigin
    @ResponseBody
    public List<App> findAppsByGenres(@RequestParam String content_rating) {
        return appRepository.findAppsByContentRating(content_rating);
    }
    
    @RequestMapping("/top/apps/download")
    @CrossOrigin
    public List<App> getTopAppsDownload() {
        return appRepository.getTopAppsDownload();
    }
    
    @RequestMapping("/top/apps/review")
    @CrossOrigin
    public List<App> getTopAppsReview() {
        return appRepository.getTopAppsReview();
    }
    
    @RequestMapping("/find/apps/most_review")
    @CrossOrigin
    public List<App> findAppsByMostReview(){
        return appRepository.findAppsByMostReview();
    }
    
    @RequestMapping("/find/apps/most_download")
    @CrossOrigin
    public List<App> findAppsByMostDownload(){
        return appRepository.findAppsByMostDownload();
    }
}

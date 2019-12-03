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

    @RequestMapping("/reviews/{id}")
    @CrossOrigin
    public List<UserReview> getReviewById(@PathVariable int id) {
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
    
    @RequestMapping("/findapp/{name}")
    @CrossOrigin
    public List<App> findAppByName(@PathVariable String name) {
        return appRepository.findAppByName(name);
    }
    
}

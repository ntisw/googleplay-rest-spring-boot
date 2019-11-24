/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soaproject.bean;

//import java.util.List;

/**
 *
 * @author nthop
 */
public class App {
    //public List<UserReview> userReviews;
    private String name;
    private String category;
    private String rating;
    private int reviews;
    private String size;
    private String installs;
    private String type;
    private float price;
    private String content_rating;
    private String genres;
    private String last_updated;
    private String current_ver;
    private String android_ver;

    public App(
            //List<UserReview> userReviews, 
            String name, String category, 
            String rating, int reviews, 
            String size, String installs, 
            String type, float price, 
            String content_rating, 
            String genres, 
            String last_updated, 
            String current_ver, 
            String android_ver
    ) {
        //this.userReviews = userReviews;
        this.name = name;
        this.category = category;
        this.rating = rating;
        this.reviews = reviews;
        this.size = size;
        this.installs = installs;
        this.type = type;
        this.price = price;
        this.content_rating = content_rating;
        this.genres = genres;
        this.last_updated = last_updated;
        this.current_ver = current_ver;
        this.android_ver = android_ver;
    }
/*
    public List<UserReview> getUserReviews() {
        return userReviews;
    }

    public void setUserReviews(List<UserReview> userReviews) {
        this.userReviews = userReviews;
    }
*/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getReviews() {
        return reviews;
    }

    public void setReviews(int reviews) {
        this.reviews = reviews;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getInstalls() {
        return installs;
    }

    public void setInstalls(String installs) {
        this.installs = installs;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getContent_rating() {
        return content_rating;
    }

    public void setContent_rating(String content_rating) {
        this.content_rating = content_rating;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(String last_updated) {
        this.last_updated = last_updated;
    }

    public String getCurrent_ver() {
        return current_ver;
    }

    public void setCurrent_ver(String current_ver) {
        this.current_ver = current_ver;
    }

    public String getAndroid_ver() {
        return android_ver;
    }

    public void setAndroid_ver(String android_ver) {
        this.android_ver = android_ver;
    }
    
}

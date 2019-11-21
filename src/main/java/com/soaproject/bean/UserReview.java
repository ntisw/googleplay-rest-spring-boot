/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soaproject.bean;

/**
 *
 * @author nthop
 */
public class UserReview {
    public String app_name;
    public String translated_review;
    public String sentiment;
    public String sentiment_polarity;
    public String sentiment_subjectivity;

    public UserReview(String app_name, String translated_review, String sentiment, String sentiment_polarity, String sentiment_subjectivity) {
        this.app_name = app_name;
        this.translated_review = translated_review;
        this.sentiment = sentiment;
        this.sentiment_polarity = sentiment_polarity;
        this.sentiment_subjectivity = sentiment_subjectivity;
    }

    public String getApp_name() {
        return app_name;
    }

    public void setApp_name(String app_name) {
        this.app_name = app_name;
    }

    public String getTranslated_review() {
        return translated_review;
    }

    public void setTranslated_review(String translated_review) {
        this.translated_review = translated_review;
    }

    public String getSentiment() {
        return sentiment;
    }

    public void setSentiment(String sentiment) {
        this.sentiment = sentiment;
    }

    public String getSentiment_polarity() {
        return sentiment_polarity;
    }

    public void setSentiment_polarity(String sentiment_polarity) {
        this.sentiment_polarity = sentiment_polarity;
    }

    public String getSentiment_subjectivity() {
        return sentiment_subjectivity;
    }

    public void setSentiment_subjectivity(String sentiment_subjectivity) {
        this.sentiment_subjectivity = sentiment_subjectivity;
    }
    
}

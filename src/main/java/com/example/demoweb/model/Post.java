package com.example.demoweb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String text;
    private int likes;
    private Date creationDate;

    public Post(Long id, String text, Date date) {
        this.id = id;
        this.text = text;
        this.creationDate = date;
        this.likes = likes;
    }

    public Post() {

    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public String getText() {
        return this.text;
    }

    public Integer getLikes() {
        return this.likes;
    }

    public Long getId() {
        return this.id;
    }

}

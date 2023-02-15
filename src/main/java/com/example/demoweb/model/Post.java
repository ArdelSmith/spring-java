package com.example.demoweb.model;

import java.util.Date;

public class Post {
    private Long id;
    private String text;
    private Integer likes;
    private Date creationDate;
    public Post(Long id, String text, Date date, Integer likes)
    {
        this.id = id;
        this.text = text;
        this.creationDate = date;
        this.likes = likes;
    }
    public void setLikes(Integer likes) {this.likes = likes;}
    public Date getCreationDate(){return this.creationDate;}
    public String getText(){return this.text;}
    public Integer getLikes() {return this.likes;}
    public Long getId() {return this.id;}

}

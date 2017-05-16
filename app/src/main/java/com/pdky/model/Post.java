package com.pdky.model;

/**
 * Created by class on 2017/5/16.
 */

public class Post {

    public int imageId;
    public String username;
    public String time;
    public String tittle;
    public String content;

    public Post(String content, int imageId, String time, String tittle, String username) {
        this.content = content;
        this.imageId = imageId;
        this.time = time;
        this.tittle = tittle;
        this.username = username;
    }


}

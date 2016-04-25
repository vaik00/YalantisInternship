package com.internship.yalantis.task2.models;

import com.google.gson.annotations.SerializedName;

public class TaskDataModel {
    @SerializedName("title")
    private String title;
    @SerializedName("image")
    private String image;
    @SerializedName("like_count")
    private String likeCount;
    @SerializedName("content")
    private String content;
    @SerializedName("date")
    private String date;
    @SerializedName("time")
    private String time;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(String likeCount) {
        this.likeCount = likeCount;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

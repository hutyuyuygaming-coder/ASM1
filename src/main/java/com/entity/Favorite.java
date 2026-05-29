package com.entity;

import java.util.Date;

public class Favorite {
    private int id;
    private int userId;
    private String videoId;
    private Date likedDate;

    // Constructors
    public Favorite() {}
    public Favorite(int id, int userId, String videoId, Date likedDate) {
        this.id = id;
        this.userId = userId;
        this.videoId = videoId;
        this.likedDate = likedDate;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getVideoId() { return videoId; }
    public void setVideoId(String videoId) { this.videoId = videoId; }

    public Date getLikedDate() { return likedDate; }
    public void setLikedDate(Date likedDate) { this.likedDate = likedDate; }

    @Override
    public String toString() {
        return "Favorite{" +
                "id=" + id +
                ", userId=" + userId +
                ", videoId='" + videoId + '\'' +
                ", likedDate=" + likedDate +
                '}';
    }
}

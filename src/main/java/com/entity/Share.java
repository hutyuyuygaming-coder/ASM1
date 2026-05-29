package com.entity;

import java.util.Date;

public class Share {
    private int id;
    private int userId;
    private String videoId;
    private String email;
    private Date sharedDate;

    // Constructors
    public Share() {}
    public Share(int id, int userId, String videoId, String email, Date sharedDate) {
        this.id = id;
        this.userId = userId;
        this.videoId = videoId;
        this.email = email;
        this.sharedDate = sharedDate;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getVideoId() { return videoId; }
    public void setVideoId(String videoId) { this.videoId = videoId; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Date getSharedDate() { return sharedDate; }
    public void setSharedDate(Date sharedDate) { this.sharedDate = sharedDate; }

    @Override
    public String toString() {
        return "Share{" +
                "id=" + id +
                ", userId=" + userId +
                ", videoId='" + videoId + '\'' +
                ", email='" + email + '\'' +
                ", sharedDate=" + sharedDate +
                '}';
    }
}

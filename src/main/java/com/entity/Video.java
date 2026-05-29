package com.entity;

public class Video {
    private String youtubeId;
    private String title;
    private String poster;
    private String description;
    private int views;
    private boolean active;

    // Constructor đầy đủ
    public Video(String youtubeId, String title, String poster, String description, int views, boolean active) {
        this.youtubeId = youtubeId;
        this.title = title;
        this.poster = poster;
        this.description = description;
        this.views = views;
        this.active = active;
    }

    // Constructor rỗng (cần cho frameworks, hoặc khi khởi tạo trước rồi set sau)
    public Video() {
    }

    // Getter & Setter
    public String getYoutubeId() {
        return youtubeId;
    }

    public void setYoutubeId(String youtubeId) {
        this.youtubeId = youtubeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}

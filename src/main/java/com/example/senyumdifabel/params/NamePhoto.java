package com.example.senyumdifabel.params;

public class NamePhoto {
    protected Long user_id;
    protected String user_name;
    protected String user_photo;
    protected String user_job;

    public NamePhoto(){}

    public NamePhoto(Long user_id, String user_name, String user_photo, String user_job) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_photo = user_photo;
        this.user_job = user_job;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_photo() {
        return user_photo;
    }

    public void setUser_photo(String user_photo) {
        this.user_photo = user_photo;
    }

    public String getUser_job() {
        return user_job;
    }

    public void setUser_job(String user_job) {
        this.user_job = user_job;
    }
}

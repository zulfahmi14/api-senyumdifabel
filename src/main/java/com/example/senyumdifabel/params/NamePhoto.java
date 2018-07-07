package com.example.senyumdifabel.params;

public class NamePhoto {
    protected String user_name;
    protected String user_photo;

    public NamePhoto(){}

    public NamePhoto(String user_name, String user_photo) {
        this.user_name = user_name;
        this.user_photo = user_photo;
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
}

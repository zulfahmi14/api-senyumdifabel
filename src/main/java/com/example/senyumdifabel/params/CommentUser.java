package com.example.senyumdifabel.params;

import com.example.senyumdifabel.comment.Comment;

public class CommentUser extends Comment {
    protected String user_name;
    protected String user_photo;

    public CommentUser(){}

    public CommentUser(Long timeline_id, Long user_id, String time, String date, String comment, String user_name, String user_photo) {
        super(timeline_id, user_id, time, date, comment);
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

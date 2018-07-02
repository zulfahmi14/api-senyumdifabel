package com.example.senyumdifabel.params;

import com.example.senyumdifabel.timeline.Timeline;

import java.util.Comparator;

public class TimelineUser extends Timeline {
    protected String user_photo ;
    protected String user_name ;
    protected Long like ;
    protected Long comments ;

    public TimelineUser() {
    }

    public TimelineUser(String user_photo, String user_name, Long like, Long comments) {
        this.user_photo = user_photo;
        this.user_name = user_name;
        this.like = like;
        this.comments = comments;
    }

    public TimelineUser(Long user_id, String timeline_description, String timeline_date, String timeline_time, String timeline_photo, String user_photo, String user_name, Long like, Long comments) {
        super(user_id, timeline_description, timeline_date, timeline_time, timeline_photo);
        this.user_photo = user_photo;
        this.user_name = user_name;
        this.like = like;
        this.comments = comments;
    }

    public String getUser_photo() {
        return user_photo;
    }

    public void setUser_photo(String user_photo) {
        this.user_photo = user_photo;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Long getLike() {
        return like;
    }

    public void setLike(Long like) {
        this.like = like;
    }

    public Long getComments() {
        return comments;
    }

    public void setComments(Long comments) {
        this.comments = comments;
    }

    public static Comparator<TimelineUser> COMPARE_BY_ID = new Comparator<TimelineUser>() {
        public int compare(TimelineUser one, TimelineUser other) {
            return one.timeline_id.compareTo(other.timeline_id);
        }
    };
}

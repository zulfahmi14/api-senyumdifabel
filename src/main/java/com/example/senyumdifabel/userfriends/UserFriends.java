package com.example.senyumdifabel.userfriends;

import javax.persistence.*;

@Entity
public class UserFriends{
    @Id
    @Column(nullable = false)
    protected Long user_id;

    @Column(nullable = false)
    protected Long user_friend;

    @Column(nullable = false)
    protected Long user_status;

    public UserFriends(){}

    public UserFriends(Long user_id, Long user_friend, Long user_status) {
        this.user_id = user_id;
        this.user_friend = user_friend;
        this.user_status = user_status;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getUser_friend() {
        return user_friend;
    }

    public void setUser_friend(Long user_friend) {
        this.user_friend = user_friend;
    }

    public Long getUser_status() {
        return user_status;
    }

    public void setUser_status(Long user_status) {
        this.user_status = user_status;
    }
}

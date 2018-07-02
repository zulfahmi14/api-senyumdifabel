package com.example.senyumdifabel.following;

import javax.persistence.*;

@Entity
public class Following {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long Id;

    @Column(nullable = false)
    public Long user_id ;

    @Column(nullable = false)
    protected String follow ;

    public Following(){}

    public Following(Long user_id, String follow) {
        this.user_id = user_id;
        this.follow = follow;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getFollow() {
        return follow;
    }

    public void setFollow(String follow) {
        this.follow = follow;
    }
}
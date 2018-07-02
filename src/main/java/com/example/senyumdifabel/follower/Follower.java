package com.example.senyumdifabel.follower;

import javax.persistence.*;

@Entity
public class Follower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long Id;

    @Column(nullable = false)
    public Long user_id ;

    @Column(nullable = false)
    protected Long follower ;

    public Follower(){}

    public Follower(Long user_id, Long follower) {
        this.user_id = user_id;
        this.follower = follower;
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

    public Long getFollower() {
        return follower;
    }

    public void setFollower(Long follower) {
        this.follower = follower;
    }
}

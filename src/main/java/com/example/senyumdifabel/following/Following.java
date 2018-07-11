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
    protected Long follow ;

    protected Boolean statusFollow ;

    public Following(){}

    public Following(Long user_id, Long follow, Boolean statusFollow) {
        this.user_id = user_id;
        this.follow = follow;
        this.statusFollow = statusFollow;
    }

    public Boolean getStatusFollow() {
        return statusFollow;
    }

    public void setStatusFollow(Boolean statusFollow) {
        this.statusFollow = statusFollow;
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

    public Long getFollow() {
        return follow;
    }

    public void setFollow(Long follow) {
        this.follow = follow;
    }
}
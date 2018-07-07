package com.example.senyumdifabel.bookmark;

import javax.persistence.*;

@Entity
public class Bookmark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id ;

    @Column(nullable = false)
    protected Long user_id ;

    @Column(nullable = false)
    protected Long job_id ;

    public Bookmark(){}

    public Bookmark(Long user_id, Long job_id) {
        this.user_id = user_id;
        this.job_id = job_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getJob_id() {
        return job_id;
    }

    public void setJob_id(Long job_id) {
        this.job_id = job_id;
    }
}

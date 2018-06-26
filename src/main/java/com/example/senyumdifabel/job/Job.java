package com.example.senyumdifabel.job;

import javax.persistence.*;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long Id;

    @Column(nullable = false)
    protected String description ;

    @Column(nullable = false)
    protected Long user_id ;

    public Job() {
    }

    public Job(String description, Long user_id) {
        this.description = description;
        this.user_id = user_id;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}

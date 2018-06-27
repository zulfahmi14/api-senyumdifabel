package com.example.senyumdifabel.likes;

import javax.persistence.*;

@Entity
public class Likes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id ;

    @Column (nullable = false)
    protected Long user_id;

    @Column (nullable = false)
    protected Long timeline_id;

    public Likes(){
    }

    public Likes(Long user_id, Long timeline_id) {
        this.user_id = user_id;
        this.timeline_id = timeline_id;
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

    public Long getTimeline_id() {
        return timeline_id;
    }

    public void setTimeline_id(Long timeline_id) {
        this.timeline_id = timeline_id;
    }
}

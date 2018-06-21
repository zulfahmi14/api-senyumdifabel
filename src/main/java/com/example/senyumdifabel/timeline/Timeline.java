package com.example.senyumdifabel.timeline;

import javax.persistence.*;

@Entity
public class Timeline {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long timeline_id;

    @Column(nullable = false)
    protected Long user_id;
    @Column(nullable = false)
    protected String timeline_description;
    @Column(nullable = false)
    protected String timeline_date;
    @Column(nullable = false)
    protected String timeline_time;

//    Constructor
    public Timeline(){

    }

    public Timeline(Long user_id, String timeline_description, String timeline_date, String timeline_time) {
        this.user_id = user_id;
        this.timeline_description = timeline_description;
        this.timeline_date = timeline_date;
        this.timeline_time = timeline_time;
    }

//    Getter
    public Long getTimeline_id() {
        return timeline_id;
    }



    public Long getUser_id() {
        return user_id;
    }

    public String getTimeline_description() {
        return timeline_description;
    }

    public String getTimeline_date() {
        return timeline_date;
    }

    public String getTimeline_time() {
        return timeline_time;
    }

//    Setter

    public void setTimeline_id(Long timeline_id) {
        this.timeline_id = timeline_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public void setTimeline_description(String timeline_description) {
        this.timeline_description = timeline_description;
    }

    public void setTimeline_date(String timeline_date) {
        this.timeline_date = timeline_date;
    }

    public void setTimeline_time(String timeline_time) {
        this.timeline_time = timeline_time;
    }
}

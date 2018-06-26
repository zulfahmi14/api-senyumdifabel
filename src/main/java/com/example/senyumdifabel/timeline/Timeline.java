package com.example.senyumdifabel.timeline;

import javax.persistence.*;

@Entity
public class Timeline {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long timeline_id;

    @Column(nullable = false)
    protected Long people_id;
    @Column(nullable = false)
    protected String timeline_description;
    @Column(nullable = false)
    protected String timeline_date;
    @Column(nullable = false)
    protected String timeline_time;

    protected String timeline_photo;

//    Constructor
    public Timeline(){

    }

    public Timeline(Long people_id, String timeline_description, String timeline_date, String timeline_time) {
        this.people_id = people_id;
        this.timeline_description = timeline_description;
        this.timeline_date = timeline_date;
        this.timeline_time = timeline_time;
    }

//    Getter
    public Long getTimeline_id() {
        return timeline_id;
    }



    public Long getPeople_id() {
        return people_id;
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

    public void setPeople_id(Long people_id) {
        this.people_id = people_id;
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

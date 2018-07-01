package com.example.senyumdifabel.comment;

import javax.persistence.*;


@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id ;

    @Column(nullable = false)
    protected Long timeline_id ;

    @Column(nullable = false)
    protected Long user_id ;

    @Column(nullable = false)
    protected String time ;

    @Column(nullable = false)
    protected String date;

    @Column(nullable = false)
    protected String comment ;

//    @OneToOne
//    @JoinColumn(name = "user_id")
//    protected People people;

    public Comment(){}

    public Comment(Long timeline_id, Long user_id, String time, String date, String comment) {
        this.timeline_id = timeline_id;
        this.user_id = user_id;
        this.time = time;
        this.date = date;
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTimeline_id() {
        return timeline_id;
    }

    public void setTimeline_id(Long timeline_id) {
        this.timeline_id = timeline_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

//    public People getPeople() {
//        return people;
//    }
//
//    public String getPeoplename() {
//        return people.getUser_name();
//    }
//    public String getPeoplephoto() {
//        return people.getUser_photo();
//    }

}

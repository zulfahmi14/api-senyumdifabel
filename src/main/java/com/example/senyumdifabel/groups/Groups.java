package com.example.senyumdifabel.groups;

import javax.persistence.*;

@Entity
public class Groups {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id ;

    @Column (nullable = false)
    protected Long sender ;

    @Column (nullable = false)
    protected Long id_prev ;

    @Column ( nullable = false)
    protected String message ;

    @Column (nullable = false)
    protected String date ;

    @Column (nullable = false)
    protected String time ;

    protected Long sort_time ;

    public Groups() {
    }

    public Groups(Long sender, Long id_prev, String message, String date, String time, Long sort_time) {
        this.sender = sender;
        this.id_prev = id_prev;
        this.message = message;
        this.date = date;
        this.time = time;
        this.sort_time = sort_time;
    }

    public Long getSort_time() {
        return sort_time;
    }

    public void setSort_time(Long sort_time) {
        this.sort_time = sort_time;
    }

    public Long getSender() {
        return sender;
    }

    public void setSender(Long sender) {
        this.sender = sender;
    }

    public Long getId_prev() {
        return id_prev;
    }

    public void setId_prev(Long id_prev) {
        this.id_prev = id_prev;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}

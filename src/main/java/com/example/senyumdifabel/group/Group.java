package com.example.senyumdifabel.group;

import javax.persistence.*;

@Entity
public class Group {
    @Id
    @Column (nullable = false)
    protected Long id ;

    @Column (nullable = false)
    protected String sender ;

    @Column (nullable = false)
    protected Long id_prev ;

    @Column ( nullable = false)
    protected String message ;

    @Column (nullable = false)
    protected String date ;

    @Column (nullable = false)
    protected String time ;

    public Group(Long id, String sender, Long id_prev, String message, String date, String time) {
        this.id = id;
        this.sender = sender;
        this.id_prev = id_prev;
        this.message = message;
        this.date = date;
        this.time = time;
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

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
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

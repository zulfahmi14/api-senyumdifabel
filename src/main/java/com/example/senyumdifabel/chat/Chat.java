package com.example.senyumdifabel.chat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Chat {
    @Id
    @Column (nullable = false)
    protected Long id ;

    @Column(nullable = false)
    protected Long id_prev ;

    @Column (nullable = false)
    protected Long sender ;

    @Column ( nullable = false)
    protected String message ;

    @Column (nullable = false)
    protected String date ;

    @Column (nullable = false)
    protected String time ;

    public Chat() {
    }

    public Chat(Long id, Long id_prev, Long sender, String message, String date, String time) {
        this.id = id;
        this.id_prev = id_prev;
        this.sender = sender;
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

    public Long getSender() {
        return sender;
    }

    public void setSender(Long sender) {
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

package com.example.senyumdifabel.prevChat;

import org.hibernate.annotations.Generated;
import org.springframework.boot.autoconfigure.web.ResourceProperties;

import javax.persistence.*;

@Entity
public class PrevChat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id ;

    @Column(nullable = false)
    protected String peopleA;

    @Column(nullable = false)
    protected String peopleB;

    @Column(nullable = false)
    protected String date;

    @Column(nullable = false)
    protected String time;

    protected String prev_chat;

    public PrevChat(){}

    public PrevChat(String peopleA, String peopleB, String date, String time, String prev_chat) {
        this.peopleA = peopleA;
        this.peopleB = peopleB;
        this.date = date;
        this.time = time;
        this.prev_chat = prev_chat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPeopleA() {
        return peopleA;
    }

    public void setPeopleA(String peopleA) {
        this.peopleA = peopleA;
    }

    public String getPeopleB() {
        return peopleB;
    }

    public void setPeopleB(String peopleB) {
        this.peopleB = peopleB;
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

    public String getPrev_chat() {
        return prev_chat;
    }

    public void setPrev_chat(String prev_chat) {
        this.prev_chat = prev_chat;
    }
}

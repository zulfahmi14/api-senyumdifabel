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
    protected Long peopleA;

    @Column(nullable = false)
    protected Long peopleB;

    @Column(nullable = false)
    protected String date;

    @Column(nullable = false)
    protected String time;

    protected String prev_chat;

    protected Long id_chat ;

    public PrevChat(){}

    public PrevChat(Long peopleA, Long peopleB, String date, String time, String prev_chat, Long id_chat) {
        this.peopleA = peopleA;
        this.peopleB = peopleB;
        this.date = date;
        this.time = time;
        this.prev_chat = prev_chat;
        this.id_chat = id_chat;
    }

    public Long getId_chat() {
        return id_chat;
    }

    public void setId_chat(Long id_chat) {
        this.id_chat = id_chat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPeopleA() {
        return peopleA;
    }

    public void setPeopleA(Long peopleA) {
        this.peopleA = peopleA;
    }

    public Long getPeopleB() {
        return peopleB;
    }

    public void setPeopleB(Long peopleB) {
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

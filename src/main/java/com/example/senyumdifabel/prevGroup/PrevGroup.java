package com.example.senyumdifabel.prevGroup;
import com.example.senyumdifabel.people.People;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class PrevGroup {
    @ManyToMany(mappedBy = "myGroup")
    private List<People> peoples = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id_prev;

    @Column (nullable = false)
    protected String group_name ;

    @Column (nullable = false)
    protected  String date ;

    @Column (nullable = false)
    protected  String time ;

    protected String prev_chat ;

    protected  String photo ;

    protected Long sort_time ;

//    @Column (nullable = false)
//    protected Long user_id ;

    public PrevGroup() {
    }

    public PrevGroup(String group_name, String date, String time, String prev_chat, String photo, Long sort_time) {
        this.group_name = group_name;
        this.date = date;
        this.time = time;
        this.prev_chat = prev_chat;
        this.photo = photo;
        this.sort_time = sort_time;
    }

    public Long getSort_time() {
        return sort_time;
    }

    public void setSort_time(Long sort_time) {
        this.sort_time = sort_time;
    }

    public Long getId_prev() {
        return id_prev;
    }

    public void setId_prev(Long id_prev) {
        this.id_prev = id_prev;
    }

    @JsonBackReference
    public List<People> getPeoples() {
        return peoples;
    }

    public void setPeoples(List<People> peoples) {
        this.peoples = peoples;
    }

    public Long getId() {
        return id_prev;
    }

    public void setId(Long id) {
        this.id_prev = id;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
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
/*
        {
            "group_name": "",
            "date": "",
            "time": "",
            "photo": ""
        }
*/
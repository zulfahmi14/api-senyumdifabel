package com.example.senyumdifabel.prevGroup;

import com.example.senyumdifabel.user.User;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class PrevGroup {
    @ManyToMany(mappedBy = "myGroup")
    private Set<User> users = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id_prev;

    @Column (nullable = false)
    protected String group_name ;

    @Column (nullable = false)
    protected  String photo ;

    @Column (nullable = false)
    protected  String date ;

    @Column (nullable = false)
    protected  String time ;

    protected String prev_chat ;

    public PrevGroup() {
    }

    public PrevGroup(Set<User> users, String group_name, String photo, String date, String time, String prev_chat) {
        this.users = users;
        this.group_name = group_name;
        this.photo = photo;
        this.date = date;
        this.time = time;
        this.prev_chat = prev_chat;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
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

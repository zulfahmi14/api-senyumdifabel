package com.example.senyumdifabel.params;

public class ChatList {
    protected Long id_prev ;
    protected String name ;
    protected String photo ;
    protected String date ;
    protected String time ;
    protected Long id_chat ;
    protected  String prev_chat ;
    protected Long size ;

    public ChatList() {
    }

    public ChatList(Long id_prev, String name, String photo, String date, String time, Long id_chat, String prev_chat, Long size) {
        this.id_prev = id_prev;
        this.name = name;
        this.photo = photo;
        this.date = date;
        this.time = time;
        this.id_chat = id_chat;
        this.prev_chat = prev_chat;
        this.size = size;
    }

    public Long getId_prev() {
        return id_prev;
    }

    public void setId_prev(Long id_prev) {
        this.id_prev = id_prev;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Long getId_chat() {
        return id_chat;
    }

    public void setId_chat(Long id_chat) {
        this.id_chat = id_chat;
    }

    public String getPrev_chat() {
        return prev_chat;
    }

    public void setPrev_chat(String prev_chat) {
        this.prev_chat = prev_chat;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }
}

package com.example.senyumdifabel.params;

import java.util.Comparator;

public class ChatList {
    protected Long id_prev ;
    protected String name ;
    protected String photo ;
    protected String date ;
    protected String time ;
    protected Long sort_time ;
    protected  String prev_chat ;
    protected Long size ;

    public ChatList() {
    }

    public ChatList(Long id_prev, String name, String photo, String date, String time, Long sort_time, String prev_chat, Long size) {
        this.id_prev = id_prev;
        this.name = name;
        this.photo = photo;
        this.date = date;
        this.time = time;
        this.sort_time = sort_time;
        this.prev_chat = prev_chat;
        this.size = size;
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

    public static Comparator<ChatList> COMPARE_BY_SORT_TIME = new Comparator<ChatList>() {
        @Override
        public int compare(ChatList chatList, ChatList t1) {
            return chatList.sort_time.compareTo(t1.sort_time);
        }
    };
}

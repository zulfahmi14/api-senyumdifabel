package com.example.senyumdifabel.params;

import com.example.senyumdifabel.groups.Groups;

public class ChatGroup extends Groups {
    protected String name ;
    protected String photo ;

    public ChatGroup() {
    }

    public ChatGroup(String name, String photo) {
        this.name = name;
        this.photo = photo;
    }

    public ChatGroup(Groups x) {
        super(x.getSender(), x.getId_prev(), x.getMessage(), x.getDate(), x.getTime(), x.getSort_time());
    }

    public ChatGroup(Long sender, Long id_prev, String message, String date, String time, Long sort_time, String name, String photo) {
        super(sender, id_prev, message, date, time, sort_time);
        this.name = name;
        this.photo = photo;
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
}

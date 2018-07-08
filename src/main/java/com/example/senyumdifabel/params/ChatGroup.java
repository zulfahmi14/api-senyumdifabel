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
        super(x.getId(), x.getSender(), x.getId_prev(), x.getMessage(), x.getDate(), x.getTime());
    }

    public ChatGroup(Long id, Long sender, Long id_prev, String message, String date, String time, String name, String photo) {
        super(id, sender, id_prev, message, date, time);
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

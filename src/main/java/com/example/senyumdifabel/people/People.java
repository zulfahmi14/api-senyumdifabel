package com.example.senyumdifabel.people;
import com.example.senyumdifabel.user.User;

import javax.persistence.*;

@Entity
public class People extends User {

//    @Column(nullable = false)
    protected String cv;

    public People(String cv) {
        this.cv = cv;
    }

    public People(String user_name, String user_email, String user_password, String user_address, String user_photo, String user_contact, String cv) {
        super(user_name, user_email, user_password, user_address, user_photo, user_contact);
        this.cv = cv;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }
}

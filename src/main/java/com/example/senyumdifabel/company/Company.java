package com.example.senyumdifabel.company;

import com.example.senyumdifabel.user.User;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Company extends User {
    @Column(nullable = false)
    protected String description ;

    public Company() {
    }

    public Company(String description) {
        this.description = description;
    }

    public Company(String user_name, String user_email, String user_password, String user_address, String user_photo, String user_contact, String description) {
        super(user_name, user_email, user_password, user_address, user_photo, user_contact);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

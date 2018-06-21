package com.example.senyumdifabel.user;


import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long user_id;

    @Column(nullable = false)
    protected String user_name;
    @Column(nullable = false)
    protected String user_email;
    @Column(nullable = false)
    protected String user_password;

    public User() {
    }

    public User(String user_name, String user_email, String user_password) {
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_password = user_password;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }


}

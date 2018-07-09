package com.example.senyumdifabel.user;
import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected Long user_id;

//    @Column(nullable = false)
    protected String user_name;
    @Column(nullable = false)
    protected String user_email;
    @Column(nullable = false)
    protected String user_password;
//    @Column(nullable = false)
    protected String user_address;
//    @Column(nullable = false)
    protected String user_photo;
//    @Column(nullable = false)
    protected String user_contact;      //contac buat bio aja

    protected boolean enabled = true;


    public User() {
    }

    public User(String user_name, String user_email, String user_password, String user_address, String user_photo, String user_contact) {
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_password = user_password;
        this.user_address = user_address;
        this.user_photo = user_photo;
        this.user_contact = user_contact;
    }

    public Long getUser_id() {
        return user_id;
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

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    public String getUser_photo() {
        return user_photo;
    }

    public void setUser_photo(String user_photo) {
        this.user_photo = user_photo;
    }

    public String getUser_contact() {
        return user_contact;
    }

    public void setUser_contact(String user_contact) {
        this.user_contact = user_contact;
    }
}

package com.example.senyumdifabel.contact;

import javax.persistence.*;

@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id ;

    @Column(nullable = false)
    protected Long user_id ;

    @Column(nullable = false)
    protected String contact ;

    @Column(nullable = false)
    protected String  form;

    public Contact(){}

    public Contact(Long user_id, String contact, String form) {
        this.user_id = user_id;
        this.contact = contact;
        this.form = form;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }
}

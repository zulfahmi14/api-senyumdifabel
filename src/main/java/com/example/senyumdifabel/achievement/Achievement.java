package com.example.senyumdifabel.achievement;

import javax.persistence.*;

@Entity
public class Achievement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id ;

    @Column(nullable = false)
    protected Long user_id ;

    @Column(nullable = false)
    protected String achivement ;

    @Column(nullable = false)
    protected String  form;

    @Column (nullable = false)
    protected String year;

    public Achievement(){}
    public Achievement(Long user_id, String achivement, String form, String year) {
        this.user_id = user_id;
        this.achivement = achivement;
        this.form = form;
        this.year = year;
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

    public String getAchivement() {
        return achivement;
    }

    public void setAchivement(String achivement) {
        this.achivement = achivement;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}

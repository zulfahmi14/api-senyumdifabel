package com.example.senyumdifabel.experience;

import javax.persistence.*;

@Entity
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id ;

    @Column(nullable = false)
    protected String title ;

    @Column(nullable = false)
    protected String description ;

    @Column(nullable = false)
    protected String year ;

    @Column(nullable = false)
    protected Long user_id ;

    public Experience() {
    }

    public Experience(String title, String description, String year, Long user_id) {
        this.title = title;
        this.description = description;
        this.year = year;
        this.user_id = user_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}

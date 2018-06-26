package com.example.senyumdifabel.education;

import com.example.senyumdifabel.people.People;

import javax.persistence.*;

@Entity
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id ;

    @Column (nullable = false)
    protected Long user_id ;

    @Column(nullable = false)
    protected String school ;

    @Column(nullable = false)
    protected String major ;

    @Column (nullable = false)
    protected String year ;

    public Education() {
    }

    public Education(Long user_id, String school, String major, String year) {
        this.user_id = user_id;
        this.school = school;
        this.major = major;
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
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

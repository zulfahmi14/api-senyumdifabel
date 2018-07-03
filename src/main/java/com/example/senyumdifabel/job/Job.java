package com.example.senyumdifabel.job;

import com.example.senyumdifabel.people.People;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Job {
    @ManyToMany(mappedBy = "myGroup")
    private List<People> peoples = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long job_id;

    @Column(nullable = false)
    protected String name ;

    @Column(nullable = false)
    protected String description ;

    @Column(nullable = false)
    protected String date ;

    @Column(nullable = false)
    protected String time ;

    @Column(nullable = false)
    protected String company_id ;

    public Job() {
    }

    public Job(String name, String description, String date, String time, String company_id) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.time = time;
        this.company_id = company_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<People> getPeoples() {
        return peoples;
    }

    public void setPeoples(List<People> peoples) {
        this.peoples = peoples;
    }

    public Long getJob_id() {
        return job_id;
    }

    public void setJob_id(Long job_id) {
        this.job_id = job_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCompany_id() {
        return company_id;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }
}

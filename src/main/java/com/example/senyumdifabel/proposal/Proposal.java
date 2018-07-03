package com.example.senyumdifabel.proposal;

import javax.persistence.*;

@Entity
public class Proposal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id ;

    @Column(nullable = false)
    protected Long status ;

    @Column(nullable = false)
    protected Long company_id ;

    @Column(nullable = false)
    protected Long job_id ;

    @Column(nullable = false)
    protected Long user_id ;

    public Proposal() {
    }

    public Proposal(Long status, Long company_id, Long job_id, Long user_id) {
        this.status = status;
        this.company_id = company_id;
        this.job_id = job_id;
        this.user_id = user_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getCompany_id() {
        return job_id;
    }

    public void setCompany_id(Long company_id) {
        this.job_id = company_id;
    }

    public Long getJob_id() {
        return job_id;
    }

    public void setJob_id(Long job_id) {
        this.job_id = job_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}

/*
{
    "user_id": 1,
    "user_name": "zull",
    "user_email": "zull@zul",
    "user_password": "$2a$10$iNxIeYxgmDLv/gkh863KROXl1pr4SS7jO7bLVKClT7M49HlrIgnLu",
    "user_address": "bogor",
    "user_photo": "zul.png",
    "user_contact": "089689910444",
    "cv": "q"
}
 */

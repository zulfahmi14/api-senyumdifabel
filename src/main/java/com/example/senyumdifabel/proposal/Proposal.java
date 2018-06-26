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
    protected Long people_id ;

    public Proposal() {
    }

    public Proposal(Long status, Long company_id, Long people_id) {
        this.status = status;
        this.company_id = company_id;
        this.people_id = people_id;
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
        return company_id;
    }

    public void setCompany_id(Long company_id) {
        this.company_id = company_id;
    }

    public Long getPeople_id() {
        return people_id;
    }

    public void setPeople_id(Long people_id) {
        this.people_id = people_id;
    }
}

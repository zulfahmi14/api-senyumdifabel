package com.example.senyumdifabel.company;

import com.example.senyumdifabel.job.Job;
import com.example.senyumdifabel.proposal.Proposal;
import com.example.senyumdifabel.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Company extends User {
    @Column(nullable = false)
    protected String description ;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id")
    protected Set<Job> jobs = new HashSet<>();

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id")
    protected Set<Proposal> proposals = new HashSet<>();

    public Company() {
    }

    public Company(String description) {
        this.description = description;
    }

    public Company(String user_name, String user_email, String user_password, String user_address, String user_photo, String user_contact, String description, Set<Job> jobs, Set<Proposal> proposals) {
        super(user_name, user_email, user_password, user_address, user_photo, user_contact);
        this.description = description;
        this.jobs = jobs;
        this.proposals = proposals;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonIgnore
    public Set<Job> getJobs() {
        return jobs;
    }

    public void setJobs(Set<Job> jobs) {
        this.jobs = jobs;
    }

    @JsonIgnore
    public Set<Proposal> getProposals() {
        return proposals;
    }

    public void setProposals(Set<Proposal> proposals) {
        this.proposals = proposals;
    }
}

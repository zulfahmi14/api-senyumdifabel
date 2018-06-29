package com.example.senyumdifabel.people;
import com.example.senyumdifabel.education.Education;
import com.example.senyumdifabel.experience.Experience;
import com.example.senyumdifabel.prevGroup.PrevGroup;
import com.example.senyumdifabel.proposal.Proposal;
import com.example.senyumdifabel.skill.Skill;
import com.example.senyumdifabel.timeline.Timeline;
import com.example.senyumdifabel.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class People extends User {
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "user_group",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = { @JoinColumn(name = "id_prev")}

    )
    protected List<PrevGroup> myGroup = new ArrayList<>();

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id")
    private List<Education> educations = new ArrayList<>();

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id")
    protected List<Experience> experiences = new ArrayList<>();

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "people_id")
    protected List<Proposal> proposals = new ArrayList<>();

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id")
    protected List<Timeline> timelines = new ArrayList<>();

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id")
    protected List<Skill> skills = new ArrayList<>();

//    @Column(nullable = false)
    protected String cv;

    public People() {
    }

    public People(String user_name, String user_email, String user_password, String user_address, String user_photo, String user_contact, String cv) {
        super(user_name, user_email, user_password, user_address, user_photo, user_contact);
        this.cv = cv;
    }

    @JsonIgnore
    public List<Timeline> getTimelines() {
        return timelines;
    }

    public void setTimelines(List<Timeline> timelines) {
        this.timelines = timelines;
    }

    @JsonIgnore
    public List<Proposal> getProposals() {
        return proposals;
    }

    public void setProposals(List<Proposal> proposals) {
        this.proposals = proposals;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    @JsonIgnore
    public List<PrevGroup> getMyGroup() {
        return myGroup;
    }

    public void setMyGroup(List<PrevGroup> myGroup) {
        this.myGroup = myGroup;
    }

    @JsonIgnore
    public List<Education> getEducations() {
        return educations;
    }

    public void setEducations(List<Education> educations) {
        this.educations = educations;
    }

    @JsonIgnore
    public List<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<Experience> experiences) {
        this.experiences = experiences;
    }

    @JsonIgnore
    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }


}
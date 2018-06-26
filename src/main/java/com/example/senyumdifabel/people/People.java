package com.example.senyumdifabel.people;
import com.example.senyumdifabel.education.Education;
import com.example.senyumdifabel.experience.Experience;
import com.example.senyumdifabel.prevGroup.PrevGroup;
import com.example.senyumdifabel.user.User;

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
    protected Set<PrevGroup> myGroup = new HashSet<>();

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id")
    protected Set<Education> educations = new HashSet<>();

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id")
    protected Set<Experience> experiences = new HashSet<>();

//    @Column(nullable = false)
    protected String cv;

    public People() {
    }

    public People(Set<PrevGroup> myGroup, String cv) {
        this.myGroup = myGroup;
        this.cv = cv;
    }

    public People(String user_name, String user_email, String user_password, String user_address, String user_photo, String user_contact, Set<PrevGroup> myGroup, String cv) {
        super(user_name, user_email, user_password, user_address, user_photo, user_contact);
        this.myGroup = myGroup;
        this.cv = cv;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public Set<PrevGroup> getMyGroup() {
        return myGroup;
    }

    public void setMyGroup(Set<PrevGroup> myGroup) {
        this.myGroup = myGroup;
    }
}

package com.example.senyumdifabel.params;

import com.example.senyumdifabel.education.Education;
import com.example.senyumdifabel.experience.Experience;
import com.example.senyumdifabel.people.People;
import com.example.senyumdifabel.skill.Skill;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

public class ProfileUser extends People {
    protected Long count_follower;
    protected Long count_following;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id")
    protected List<Experience> experiences;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id")
    protected List<Education> educations;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id")
    protected List<Skill> skills;


}

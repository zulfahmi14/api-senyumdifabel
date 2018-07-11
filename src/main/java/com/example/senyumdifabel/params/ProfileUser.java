package com.example.senyumdifabel.params;

import com.example.senyumdifabel.achievement.Achievement;
import com.example.senyumdifabel.contact.Contact;
import com.example.senyumdifabel.education.Education;
import com.example.senyumdifabel.experience.Experience;
import com.example.senyumdifabel.people.People;
import com.example.senyumdifabel.skill.Skill;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

public class ProfileUser extends People {
    protected Long count_follower;
    protected Long count_following;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id")
    protected List<Experience> experiences = new ArrayList<>();

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id")
    protected List<Education> educations = new ArrayList<>();

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id")
    protected List<Skill> skills = new ArrayList<>();

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id")
    protected List<Achievement> achievements = new ArrayList<>();

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id")
    protected List<Contact> contacts = new ArrayList<>();

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id")
    protected List<TimelineUser> timelineUsers = new ArrayList<>();


    public ProfileUser(){}

    public ProfileUser(String user_name, String user_email, String user_password, String user_address, String user_photo, String user_contact, String cv, String user_job, Long count_follower, Long count_following, List<Experience> experiences, List<Education> educations, List<Skill> skills, List<Achievement> achievements, List<Contact> contacts, List<TimelineUser> timelineUsers) {
        super(user_name, user_email, user_password, user_address, user_photo, user_contact, cv, user_job);
        this.count_follower = count_follower;
        this.count_following = count_following;
    }

    public Long getCount_follower() {
        return count_follower;
    }

    public void setCount_follower(Long count_follower) {
        this.count_follower = count_follower;
    }

    public Long getCount_following() {
        return count_following;
    }

    public void setCount_following(Long count_following) {
        this.count_following = count_following;
    }

    @Override
    public List<Experience> getExperiences() {
        return experiences;
    }

    @Override
    public void setExperiences(List<Experience> experiences) {
        this.experiences = experiences;
    }

    @Override
    public List<Education> getEducations() {
        return educations;
    }

    @Override
    public void setEducations(List<Education> educations) {
        this.educations = educations;
    }

    @Override
    public List<Skill> getSkills() {
        return skills;
    }

    @Override
    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    @Override
    public List<Achievement> getAchievements() {
        return achievements;
    }

    @Override
    public void setAchievements(List<Achievement> achievements) {
        this.achievements = achievements;
    }

    @Override
    public List<Contact> getContacts() {
        return contacts;
    }

    @Override
    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public List<TimelineUser> getTimelineUsers() {
        return timelineUsers;
    }

    public void setTimelineUsers(List<TimelineUser> timelineUsers) {
        this.timelineUsers = timelineUsers;
    }
}

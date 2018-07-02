package com.example.senyumdifabel.people;

import com.example.senyumdifabel.achievement.Achievement;
import com.example.senyumdifabel.contact.Contact;
import com.example.senyumdifabel.education.Education;
import com.example.senyumdifabel.experience.Experience;
import com.example.senyumdifabel.params.ProfileUser;
import com.example.senyumdifabel.prevGroup.PrevGroup;
import com.example.senyumdifabel.skill.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeopleRepository extends JpaRepository< People, Long> {
    @Query("select myGroup from People p where p.user_id = ?1")
    List<PrevGroup> findMyGroup(Long user_id);

    @Query("select u from People u where u.user_email = ?1")
    List<People> findEmail(String email);

    @Query("select p from People p where p.user_id = ?1")
    ProfileUser  findProfile(Long user_id);

    @Query("select e from Experience e where e.user_id= ?1")
    List<Experience> findExperience(Long user_id);

    @Query("select e from Education e where e.user_id= ?1")
    List<Education> findEducation(Long user_id);

    @Query("select e from Skill e where e.user_id= ?1")
    List<Skill> findSkill(Long user_id);

    @Query("select e from Achievement e where e.user_id= ?1")
    List<Achievement> findAchievement(Long user_id);

    @Query("select e from Contact e where e.user_id= ?1")
    List<Contact> findContact(Long user_id);

    @Query("select COUNT (p) from Following p where p.user_id = ?1")
    Long findConFollowing(Long user_id);

    @Query("select COUNT (p) from Follower p where p.user_id = ?1")
    Long findConFollower(Long user_id);

//    @Query("select t from Timeline ")


}

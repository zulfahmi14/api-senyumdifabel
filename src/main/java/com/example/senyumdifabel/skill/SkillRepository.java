package com.example.senyumdifabel.skill;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillRepository extends JpaRepository< Skill, Long> {
    @Query("select u from Skill u where u.user_id = ?1")
    List<Skill> findSkill(Long user_id);
}

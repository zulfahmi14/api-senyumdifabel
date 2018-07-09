package com.example.senyumdifabel.experience;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExperienceRepository extends JpaRepository< Experience, Long> {
    @Query("select u from Experience u where u.user_id = ?1")
    List<Experience> findExp(Long user_id);

    @Query("select u from Experience u where u.user_id = ?1 order by u.id desc")
    List<Experience> findJob(Long user_id);
}

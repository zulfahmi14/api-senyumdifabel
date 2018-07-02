package com.example.senyumdifabel.achievement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AchievementRepository extends JpaRepository<Achievement, Long> {
    @Query("select u from Achievement u where u.user_id = ?1")
    List<Achievement> findAchi(Long user_id);

}

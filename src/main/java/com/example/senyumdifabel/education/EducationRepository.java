package com.example.senyumdifabel.education;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EducationRepository extends JpaRepository< Education, Long> {
    @Query("select u from Education u where u.user_id = ?1")
    List<Education> findEdu(Long user_id);
}

package com.example.senyumdifabel.prevGroup;

import com.example.senyumdifabel.people.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrevGroupRepository extends JpaRepository< PrevGroup, Long> {
    @Query("select peoples from PrevGroup u where u.id_prev = ?1")
    List<People> findMember(Long user_id);
}

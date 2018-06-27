package com.example.senyumdifabel.people;

import com.example.senyumdifabel.prevGroup.PrevGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeopleRepository extends JpaRepository< People, Long> {
    @Query("select myGroup from People p where p.user_id = ?1")
    List<PrevGroup> findMyGroup(Long user_id);

    @Query("select u from People u where u.user_name = ?1 and u.user_password = ?2")
    People login(String name, String password);
}

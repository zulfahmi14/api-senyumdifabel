package com.example.senyumdifabel.groups;

import com.example.senyumdifabel.people.People;
import com.example.senyumdifabel.prevGroup.PrevGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupsRepository extends JpaRepository<Groups,Long> {
    @Query("select u from Groups u where u.id_prev = ?1")
    List<Groups> loadGroupChat(Long id);

    @Query("select u from PrevGroup u where id_prev = ?1")
    PrevGroup findPrev(Long id) ;

    @Query("select u from People u where user_id = ?1")
    People findUser(Long id) ;

    @Query("select u.peoples from PrevGroup u where id_prev = ?1")
    List<People> findMember(Long id) ;
}

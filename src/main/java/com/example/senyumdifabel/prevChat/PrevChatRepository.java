package com.example.senyumdifabel.prevChat;

import com.example.senyumdifabel.people.People;
import com.example.senyumdifabel.prevGroup.PrevGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrevChatRepository  extends JpaRepository<PrevChat,Long> {
    @Query("select u from PrevChat u where u.peopleA = ?1 or u.peopleB = ?1")
    List<PrevChat> findMyChat(Long idx);

    @Query("select u from PrevGroup u where u.id_prev = ?1")
    List<PrevGroup> findMyGroup(Long idx);

    @Query("select u from People u where u.user_id = ?1")
    People findPeople(Long idx);

    @Query("select COUNT (peoples) from PrevGroup u where u.id_prev = ?1")
    Long findCountMember(Long id);

}

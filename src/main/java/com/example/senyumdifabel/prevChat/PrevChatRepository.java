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
    PrevGroup findMyGroup(Long idx);

    @Query("select u.id_prev from UserGroup u where u.user_id = ?1")
    List<Long> findGroupId(Long idx);

    @Query("select u from People u where u.user_id = ?1")
    People findPeople(Long idx);

    @Query("select COUNT (u.user_id) from UserGroup u where u.id_prev = ?1")
    Long findCountMember(Long id);

    @Query("select COUNT (com) from FlagChat com where com.user_id = ?1 and com.id_prev = ?2 and com.flag = false and com.type = 2L")
    Long countFlagGroup(Long x, Long y);

    @Query("select COUNT (com) from FlagChat com where com.user_id = ?1 and com.id_prev = ?2 and com.flag = false and com.type = 1L")
    Long countFlagChat(Long x, Long y);

}

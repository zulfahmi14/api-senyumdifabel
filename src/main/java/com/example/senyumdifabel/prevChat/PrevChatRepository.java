package com.example.senyumdifabel.prevChat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrevChatRepository  extends JpaRepository<PrevChat,Long> {
    @Query("select u from PrevChat u where u.peopleA = ?1 or u.peopleB = ?1")
    List<PrevChat> findMyChat(Long idx);
}

package com.example.senyumdifabel.chat;

import com.example.senyumdifabel.prevChat.PrevChat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepository extends JpaRepository<Chat,Long> {
    @Query("select u from Chat u where u.id_prev = ?1")
    List<Chat> loadChat(Long idx);

    @Query("select u from PrevChat u where u.id = ?1")
    PrevChat findPrev(Long idx);
}

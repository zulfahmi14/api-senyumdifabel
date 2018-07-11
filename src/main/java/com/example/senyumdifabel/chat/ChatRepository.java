package com.example.senyumdifabel.chat;

import com.example.senyumdifabel.flagChat.FlagChat;
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

    @Query("select com from FlagChat com where com.user_id = ?1 and com.id_prev = ?2 and com.flag = false and com.type = 1L")
    List<FlagChat> countFlagChat(Long x, Long y);
}

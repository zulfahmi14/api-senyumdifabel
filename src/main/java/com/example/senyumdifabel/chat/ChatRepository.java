package com.example.senyumdifabel.chat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepository extends JpaRepository<Chat,Long> {
    @Query("select u from Chat u where u.id_prev = ?1")
    List<Chat> loadChat(Long idx);
}

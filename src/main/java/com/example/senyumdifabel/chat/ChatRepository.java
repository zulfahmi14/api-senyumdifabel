package com.example.senyumdifabel.chat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<Chat,Long> {
    @Query("select u from Chat u where u.id = ?1")
    Chat findChat(Long idx);
}

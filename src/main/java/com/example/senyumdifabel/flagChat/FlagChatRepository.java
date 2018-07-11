package com.example.senyumdifabel.flagChat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FlagChatRepository extends JpaRepository<FlagChat, Long> {
    @Query("select COUNT (com) from FlagChat com where com.user_id = ?1 and com.flag = ?2")
    Long findCountFlag(Long y, Boolean x);
}

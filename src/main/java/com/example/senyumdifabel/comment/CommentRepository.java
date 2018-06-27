package com.example.senyumdifabel.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository< Comment, Long> {
    @Query("select u from Comment u where u.timeline_id = ?1")
    List<Comment> findCom(Long timeline_id);
}

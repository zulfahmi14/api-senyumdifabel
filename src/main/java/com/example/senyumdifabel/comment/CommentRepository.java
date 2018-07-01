package com.example.senyumdifabel.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository< Comment, Long> {
    @Query("select u from Comment u where u.timeline_id = ?1")
    List<Comment> findCom(Long timeline_id);

    @Query("select COUNT (com) from Comment com where com.timeline_id = ?1")
    Long countCom(Long timeline_id);
}

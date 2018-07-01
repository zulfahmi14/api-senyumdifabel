package com.example.senyumdifabel.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository< Comment, Long> {
    @Query("select u from Comment u  where u.timeline_id = ?1")
//    @Query("select count (u) from Comment u inner join u.people p on u.user_id=p.user_id where u.timeline_id = ?1")
    Long findCom(Long timeline_id);
    //user_name, user_photo, time, date, comment, id

    @Query("select COUNT (com) from Comment com where com.timeline_id = ?1")
    Long countCom(Long timeline_id);
}

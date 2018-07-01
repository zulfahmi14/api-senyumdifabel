package com.example.senyumdifabel.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.senyumdifabel.people.People;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository< Comment, Long> {
//    @Query("select u from Comment u  where u.timeline_id = ?1")
//    @Query("select count (u) from Comment u inner join u.people p on u.user_id=p.user_id where u.timeline_id = ?1")
//    Long findCom(Long timeline_id);
    //user_name, user_photo, time, date, comment, id

    @Query("select COUNT (com) from Comment com where com.timeline_id = ?1")
    Long countCom(Long timeline_id);

    @Query("select u from Comment u  where u.timeline_id = ?1")
    List<Comment> findComment(Long id);

    @Query("select user_name from People u where u.user_id = ?1")
    String findUserName(Long id);

    @Query("select user_photo from People u where u.user_id = ?1")
    String findUserPhoto(Long id);
}

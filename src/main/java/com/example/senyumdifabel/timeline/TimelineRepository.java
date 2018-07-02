package com.example.senyumdifabel.timeline;
import com.example.senyumdifabel.following.Following;
//import com.example.senyumdifabel.people.People;
//import com.example.senyumdifabel.likes.Likes;
//import com.example.senyumdifabel.comment.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimelineRepository  extends JpaRepository<Timeline,Long>  {
    @Query("select u from Timeline u where u.user_id = ?1")
    List<Timeline> findTimeline(long user_id);

    @Query("select u from Following u where u.user_id = ?1")
    List<Following> findFollowing(Long id);

    @Query("select user_name from People u where u.user_id = ?1")
    String FindUserName(Long y);

    @Query("select user_photo from People u where u.user_id = ?1")
    String FindPhoto(Long y);

    @Query("select COUNT (com) from Likes com where com.timeline_id = ?1")
    Long FindCountLike(Long y);

    @Query("select COUNT (com) from Comment com where com.timeline_id = ?1")
    Long FindCountComment(Long y);


//    @Query("select t from Timeline t inner join t.comment where t.user_id = ?1")
//    List<Timeline> findTimelinekeren(Long user_id);
}
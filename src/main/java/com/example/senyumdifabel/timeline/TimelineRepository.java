package com.example.senyumdifabel.timeline;
import com.example.senyumdifabel.comment.Comment;
import com.example.senyumdifabel.experience.Experience;
import com.example.senyumdifabel.following.Following;
//import com.example.senyumdifabel.people.People;
//import com.example.senyumdifabel.likes.Likes;
//import com.example.senyumdifabel.comment.Comment;
import com.example.senyumdifabel.likes.Likes;
import com.example.senyumdifabel.people.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimelineRepository  extends JpaRepository<Timeline,Long>  {
    @Query("select u from Timeline u where u.user_id = ?1")
    List<Timeline> findTimeline(long user_id);

    @Query("select u from Timeline u where u.timeline_id = ?1")
    Timeline findId(long timeline_id);

    @Query("select u from Following u where u.user_id = ?1")
    List<Following> findFollowing(long id);

    @Query("select u from People u where u.user_id = ?1")
    People FindUser(long y);

    @Query("select u.experiences from People u where u.user_id = ?1")
    List<Experience> FindEx(long y) ;

    @Query("select COUNT (com) from Likes com where com.timeline_id = ?1")
    Long FindCountLike(Long y);

    @Query("select COUNT (com) from Comment com where com.timeline_id = ?1")
    Long FindCountComment(Long y);

    @Query("select u from Comment u where u.timeline_id = ?1")
    List<Comment> findCom(long y) ;

    @Query("select u from Likes u where u.timeline_id = ?1")
    List<Likes> findLike(long y) ;

}
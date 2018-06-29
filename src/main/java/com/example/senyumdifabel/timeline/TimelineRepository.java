package com.example.senyumdifabel.timeline;
import com.example.senyumdifabel.following.Following;
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
}
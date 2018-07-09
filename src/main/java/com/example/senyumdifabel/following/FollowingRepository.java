package com.example.senyumdifabel.following;

import com.example.senyumdifabel.experience.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowingRepository extends JpaRepository<Following, Long> {
    @Query("select u from Following u where u.user_id = ?1")
    List<Following> findFollowing(Long id);

    @Query("select u from Following u where u.follow = ?1")
    List<Following> findFollower(Long id);

    @Query("select u.user_name from People u where u.user_id = ?1")
    String findUserName(Long id);

    @Query("select u.user_photo from People u where u.user_id = ?1")
    String findUserPhoto(Long id);

    @Query("select u.title, u.description from Experience u where u.user_id = ?1 order by u.id desc")
    List<Experience> findJob(Long user_id);
}
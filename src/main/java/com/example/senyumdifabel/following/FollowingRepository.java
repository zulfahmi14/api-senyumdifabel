package com.example.senyumdifabel.following;

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
}

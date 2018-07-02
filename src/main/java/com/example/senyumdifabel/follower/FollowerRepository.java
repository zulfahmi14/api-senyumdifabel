package com.example.senyumdifabel.follower;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowerRepository extends JpaRepository<Follower,Long> {
    @Query("select u from Follower u where u.user_id = ?1")
    List<Follower> findFollower(Long id);

}

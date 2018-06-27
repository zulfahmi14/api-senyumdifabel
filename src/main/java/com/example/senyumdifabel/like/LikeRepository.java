package com.example.senyumdifabel.like;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeRepository extends JpaRepository< Like, Long> {
    @Query("select u from Like u where u.timeline_id = ?1")
    List<Like> findLike(Long timeline_id);
}

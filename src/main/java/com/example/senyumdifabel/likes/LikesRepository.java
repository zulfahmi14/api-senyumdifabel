package com.example.senyumdifabel.likes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikesRepository extends JpaRepository< Likes, Long> {
    @Query("select u from Likes u where u.timeline_id = ?1")
    List<Likes> findLike(Long timeline_id);
}

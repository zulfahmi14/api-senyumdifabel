package com.example.senyumdifabel.bookmark;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
    @Query("select u from Bookmark u where u.user_id = ?1")
    List<Bookmark> findMark(Long user_id);
}

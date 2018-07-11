package com.example.senyumdifabel.job;

import com.example.senyumdifabel.bookmark.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository< Job, Long> {
    @Query("select u from Job u where u.job_id = ?1")
    Job findJob(Long job_id);

    @Query("select u from Company u where u.user_id=?1")
    String findCompanyName(Long user_id);

    @Query("select u from Bookmark u where u.user_id=?1")
    List<Bookmark> findBookmark(Long user_id);
}

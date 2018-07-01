package com.example.senyumdifabel.job;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository< Job, Long> {
//    @Query("select u from Job u where u.user_id = ?1")
//    List<Job> findJob(Long user_id);
}

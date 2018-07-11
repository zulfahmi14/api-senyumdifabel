package com.example.senyumdifabel.proposal;

import com.example.senyumdifabel.bookmark.Bookmark;
import com.example.senyumdifabel.job.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProposalRepository extends JpaRepository< Proposal, Long> {
    @Query("select u from Proposal u where u.job_id = ?1")
    List<Proposal> findByCompany(Long company_id);

    @Query("select u from Proposal u where u.user_id = ?1")
    List<Proposal> findByUser(Long user_id);

    @Query("select u from Job u where u.job_id = ?1")
    Job findJob(Long job_id);

    @Query("select u from Company u where u.user_id = ?1")
    String findCompanyName(Long user_id);

    @Query("select u from Bookmark u where u.user_id=?1")
    List<Bookmark> findBookmark(Long user_id);

    @Query("select u from Proposal u where u.user_id=?1 and u.status=1")
    List<Proposal> findAppliedJob(Long user_id);

    @Query("select u from Proposal u where u.user_id=?1 and u.status=2")
    List<Proposal> findInterview(Long user_id);

    @Query("select u from Proposal u where u.user_id=?1 and u.status=3")
    List<Proposal> findFailed(Long user_id);

    @Query("select count (u) from Bookmark u where u.user_id=?1")
    Long countBookmark(Long user_id);

    @Query("select count(u) from Proposal u where u.user_id=?1 and u.status=1")
    Long countAppliedJob(Long user_id);

    @Query("select count(u) from Proposal u where u.user_id=?1 and u.status=2")
    Long countInterview(Long user_id);

    @Query("select count(u) from Proposal u where u.user_id=?1 and u.status=3")
    Long countFailed(Long user_id);

}

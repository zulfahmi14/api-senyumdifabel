package com.example.senyumdifabel.proposal;

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
}

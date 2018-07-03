package com.example.senyumdifabel.notification;

import com.example.senyumdifabel.proposal.Proposal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NotificationRepository extends JpaRepository< Notification, Long> {

    @Query("select user_photo from People u where u.user_id = ?1")
    String FindPhoto(Long y) ;

    @Query("select COUNT (com) from Likes com where com.timeline_id = ?1")
    Long FindCountLike(Long y) ;

    @Query("select u from Notification u where u.user_id = ?1 and u.enable = ?2")
    List<Notification> findbyEnable(Long y, Boolean boo) ;

    @Query("select  p from Proposal p where p.id = ?1")
    Proposal findProposal(Long id) ;

    @Query("select  user_name from Company c where c.user_id = ?1")
    String findCompanyName(Long id) ;


    @Query("select  user_photo from Company c where c.user_id = ?1")
    String findCompanyPhoto(Long id) ;

    @Query("select  status from Proposal p where p.id = ?1")
    Long findStatus(Long id) ;

    @Query("select  job_id from Proposal p where p.id = ?1")
    Long findJobId(Long id) ;

    @Query("select  name from Job c where c.job_id = ?1")
    String findJobName(Long id) ;

}

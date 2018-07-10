package com.example.senyumdifabel.notification;

import com.example.senyumdifabel.people.People;
import com.example.senyumdifabel.proposal.Proposal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NotificationRepository extends JpaRepository< Notification, Long> {

    @Query("select COUNT (n) from Notification n where n.user_id = ?1")
    Long CountEnable(Long y) ;

    @Query("select u from Notification u where u.user_id = ?1 and u.enable = ?2")
    List<Notification> findbyEnable(Long y, Boolean boo) ;

    @Query("select u from Notification u where u.user_id = ?1")
    List<Notification> findbyUser(Long y) ;

    @Query("select  p from Proposal p where p.id = ?1")
    Proposal findProposal(Long id) ;

    @Query("select  user_name from Company c where c.user_id = ?1")
    String findCompanyName(Long id) ;


    @Query("select  user_photo from Company c where c.user_id = ?1")
    String findCompanyPhoto(Long id) ;

    @Query("select  name from Job c where c.job_id = ?1")
    String findJobName(Long id) ;

    @Query("select  u from People u where u.user_id = ?1")
    People findPeople(Long id) ;

    @Query("select  COUNT (u) from Following u where u.user_id = ?1 and u.follow = ?2")
    Long findFoll(Long id1 , Long id2) ; // 1 = kita sudah follow, 0 kita belum follow
}

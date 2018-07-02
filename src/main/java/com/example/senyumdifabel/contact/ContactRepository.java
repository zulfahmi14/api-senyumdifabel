package com.example.senyumdifabel.contact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    @Query("select u from Contact u where u.user_id = ?1")
    List<Contact> findCon(Long user_id);
}

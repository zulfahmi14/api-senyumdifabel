package com.example.senyumdifabel.group;

import com.example.senyumdifabel.prevGroup.PrevGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group,Long> {
    @Query("select u from Group u where u.id_prev = ?1")
    List<Group> loadGroupChat(Long idx);

    @Query("select u from PrevGroup u where id_prev = ?1")
    PrevGroup findPrev(Long id) ;
}

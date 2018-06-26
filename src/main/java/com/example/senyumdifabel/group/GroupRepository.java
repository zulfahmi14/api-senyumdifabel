package com.example.senyumdifabel.group;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group,Long> {
    @Query("select u from Group u where u.id = ?1")
    Group findGroup(Long idx);
}

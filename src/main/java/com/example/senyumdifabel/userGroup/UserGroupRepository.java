package com.example.senyumdifabel.userGroup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserGroupRepository extends JpaRepository<UserGroup,Long> {
    @Query("select u from UserGroup u where u.user_id = ?1")
    List<UserGroup> findMyGroup(Long user_id);

    @Query("select u from UserGroup u where u.user_id = ?1 and u.id_prev = ?2")
    UserGroup findByUserGroup(long user_id , long id_prev);
}

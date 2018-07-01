package com.example.senyumdifabel.userGroup;

import org.omg.CORBA.LongHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.xml.ws.Holder;
import java.util.List;

public interface UserGroupRepository extends JpaRepository<UserGroup,Long> {
    @Query("select u from UserGroup u where u.user_id = ?1")
    List<UserGroup> findMyGroup(Long user_id);

    @Query("select u from UserGroup u where u.user_id = ?1 and u.id_prev = ?2")
    UserGroup findByUserGroup(Long user_id , Long id_prev);
}

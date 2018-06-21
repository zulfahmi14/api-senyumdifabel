package com.example.senyumdifabel.userfriends;
import com.example.senyumdifabel.user.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserFriendsRepository extends JpaRepository<UserFriends,Long>{
    @Query("select u from UserFriends u where u.user_friend = ?1")
    UserFriends findByUser_friend(Long user_friend);
}

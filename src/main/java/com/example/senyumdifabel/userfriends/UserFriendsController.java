package com.example.senyumdifabel.userfriends;

import com.example.senyumdifabel.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class UserFriendsController {
    private UserFriendsRepository userFriendsRepository ;

    @Autowired
    public UserFriendsController(UserFriendsRepository userFriendsRepository){
        this.userFriendsRepository = userFriendsRepository ;
    }

    @PostMapping("/addfriend")
    public UserFriends register(@RequestBody UserFriends userFriends){
        return userFriendsRepository.save(userFriends);
    }

    @GetMapping("/friendrequest/{id}")
    public UserFriends getfriendrequest(@PathVariable(value ="id") Long x){
        return userFriendsRepository.findByUser_friend(x);
    }

}

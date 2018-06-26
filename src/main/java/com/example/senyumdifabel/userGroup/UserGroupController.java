package com.example.senyumdifabel.userGroup;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserGroupController {
    private UserGroupRepository userGroupRepository ;

    public UserGroupController(UserGroupRepository userGroupRepository) {
        this.userGroupRepository = userGroupRepository;
    }

    @PostMapping("/joinGroup")
    public UserGroup joinGroup(@RequestBody UserGroup userGroup){
        return userGroupRepository.save(userGroup);
    }

}

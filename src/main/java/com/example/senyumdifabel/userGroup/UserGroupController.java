package com.example.senyumdifabel.userGroup;

import com.example.senyumdifabel.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

//    @GetMapping("/myGroup/{id}")
//    public List<UserGroup> myGroup(@PathVariable(value = "id") Long id){
//        return userGroupRepository.findMyGroup(id) ;
//    }
}

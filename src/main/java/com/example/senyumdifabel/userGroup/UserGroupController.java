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

    @DeleteMapping("/leaveGroup/{id}")
    public boolean deleteuser(@PathVariable(value = "id") Long id) {
        UserGroup people = userGroupRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
        userGroupRepository.delete(people);
        return true;
    }

//    @GetMapping("/myGroup/{id}")
//    public List<UserGroup> myGroup(@PathVariable(value = "id") Long id){
//        return userGroupRepository.findMyGroup(id) ;
//    }
}

// POST
//{
//        "id_prev": "1",
//        "user_id": "1",
//        "time": "019213",
//        "date": "131313"
//}
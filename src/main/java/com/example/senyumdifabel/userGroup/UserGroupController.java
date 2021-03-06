package com.example.senyumdifabel.userGroup;

import com.example.senyumdifabel.params.Params;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserGroupController {
    private UserGroupRepository userGroupRepository ;

    public UserGroupController(UserGroupRepository userGroupRepository) {
        this.userGroupRepository = userGroupRepository;
    }

    @PostMapping("/auth/joinGroup")
    public UserGroup joinGroup(@RequestBody UserGroup userGroup){
        return userGroupRepository.save(userGroup);
    }

    @PostMapping("/auth/leaveGroup")
    public boolean deleteuser(@RequestBody Params x) {
        Long x1 = x.getParam1() ;
        Long x2 = x.getParam2() ;
        UserGroup leave = userGroupRepository.findByUserGroup(x1,x2);
        if(leave == null)
        {
            return false ;
        }
        else
        {
            userGroupRepository.delete(leave);
            return true ;
        }

    }
}

/*
LEAVE GROUP

{
	"param1": "1", // user_id
	"param2": "1"  // id_prev
}

 */
package com.example.senyumdifabel.group;

import com.example.senyumdifabel.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GroupController {
    private GroupRepository groupRepository;

    @Autowired
    public GroupController(GroupRepository groupRepository){this.groupRepository = groupRepository;}

    @PostMapping("/sendMessageGroup")
    public Group sendMessage(@RequestBody Group group){
        return groupRepository.save(group);
    }

    @GetMapping("/loadGroup/{id}")
    public Group loadGroup(@PathVariable(value ="id") Long x){
        return groupRepository.findById(x).orElseThrow(() -> new ResourceNotFoundException("Id " + x.toString() + " not found"));
    }

}

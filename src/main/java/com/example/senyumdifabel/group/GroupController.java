package com.example.senyumdifabel.group;

import com.example.senyumdifabel.ResourceNotFoundException;
import com.example.senyumdifabel.prevGroup.PrevGroup;
import com.example.senyumdifabel.prevGroup.PrevGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GroupController {
    private GroupRepository groupRepository;

    @Autowired
    public GroupController(GroupRepository groupRepository){this.groupRepository = groupRepository;}

    @PostMapping("/auth/sendMessageGroup")
    public Group sendMessage(@RequestBody Group group){
        return groupRepository.save(group);
    }

    @GetMapping("/auth/getGroup/{id}")
    public Group getGroup(@PathVariable(value ="id") Long x){
        return groupRepository.findById(x).orElseThrow(() -> new ResourceNotFoundException("Id " + x.toString() + " not found"));
    }

    @GetMapping("/auth/loadChatGroup/{id}")
    public List<Group> loadGroup(@PathVariable(value ="id") Long x){
        return groupRepository.loadGroupChat(x);
    }

    @DeleteMapping("/auth/deleteChatGroup/{id}")
    public boolean deleteChatGroup(@PathVariable(value = "id") Long id) {
        Group people = groupRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
        groupRepository.delete(people);
        return true;
    }

}

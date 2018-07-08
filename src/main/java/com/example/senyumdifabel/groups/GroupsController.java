package com.example.senyumdifabel.groups;

import com.example.senyumdifabel.ResourceNotFoundException;
import com.example.senyumdifabel.params.ChatGroup;
import com.example.senyumdifabel.people.People;
import com.example.senyumdifabel.prevGroup.PrevGroup;
import com.example.senyumdifabel.prevGroup.PrevGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class GroupsController {
    private GroupsRepository groupsRepository ;
    private PrevGroupRepository prevGroupRepository ;

    @Autowired
    public GroupsController(GroupsRepository groupsRepository, PrevGroupRepository prevGroupRepository) {
        this.groupsRepository = groupsRepository;
        this.prevGroupRepository = prevGroupRepository;
    }

    @PostMapping("/auth/sendMessageGroup")
    public Groups sendMessage(@RequestBody Groups group){
        PrevGroup prev = groupsRepository.findPrev(group.getId_prev());
        //prev.setId_chat();configure .htaccess in tomcat
        prev.setPrev_chat(group.getMessage());
        prev.setDate(group.getDate());
        prev.setTime(group.getTime());
        prevGroupRepository.save(prev);
        return groupsRepository.save(group);
    }

    @GetMapping("/auth/getGroup/{id}")
    public Groups getGroup(@PathVariable(value ="id") Long x){
        return groupsRepository.findById(x).orElseThrow(() -> new ResourceNotFoundException("Id " + x.toString() + " not found"));
    }

    @GetMapping("/auth/loadChatGroup/{id}")
    public List<ChatGroup> loadGroup(@PathVariable(value ="id") Long x){
        List<ChatGroup> temp = new ArrayList<>() ;
        List<Groups> group;
        group = groupsRepository.loadGroupChat(x);
        for(int i = 0 ; i < group.size() ; i++)
        {
            ChatGroup temp2 = new ChatGroup(group.get(i));
            People p = groupsRepository.findUser(group.get(i).getSender()) ;
            temp2.setName(p.getUser_name());
            temp2.setPhoto(p.getUser_photo());
            temp.add(temp2);
        }
        return temp ;
    }

    @DeleteMapping("/auth/deleteChatGroup/{id}")
    public boolean deleteChatGroup(@PathVariable(value = "id") Long id) {
        Groups people = groupsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
        groupsRepository.delete(people);
        return true;
    }
}

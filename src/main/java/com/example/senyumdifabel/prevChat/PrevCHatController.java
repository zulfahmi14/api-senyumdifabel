package com.example.senyumdifabel.prevChat;

import com.example.senyumdifabel.ResourceNotFoundException;
import com.example.senyumdifabel.params.ChatList;
import com.example.senyumdifabel.people.People;
import com.example.senyumdifabel.prevGroup.PrevGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class PrevCHatController {
    private PrevChatRepository prevChatRepository ;

    @Autowired
    public PrevCHatController(PrevChatRepository prevChatRepository){ this.prevChatRepository = prevChatRepository ;}

    @PostMapping("/auth/addChat")
    public PrevChat addChat(@RequestBody PrevChat prevChat){
        return prevChatRepository.save(prevChat);
    }

    @GetMapping("/auth/listChat/{id}") // user_id
    public List<ChatList> listChat(@PathVariable(value ="id") Long x){
        List<ChatList> chatgroup = new ArrayList<>() ;

        List<PrevChat> chat = prevChatRepository.findMyChat(x);
        List<Long> group_id = prevChatRepository.findGroupId(x);
        List<PrevGroup> group = new ArrayList<>();

        // find group by id
        for(int i = 0 ; i < group_id.size() ; i++)
        {
            PrevGroup temp2 = prevChatRepository.findMyGroup(group_id.get(i));
            group.add(temp2);
        }

        for(int i = 0 ; i < chat.size() ; i++)
        {
            ChatList temp = new ChatList();
            temp.setId_prev(chat.get(i).getId());
            People _people = new People();
            if(x == chat.get(i).getPeopleA())
            {
                _people = prevChatRepository.findPeople(chat.get(i).getPeopleB());
            }
            else
            {
                _people = prevChatRepository.findPeople(chat.get(i).getPeopleA());
            }
            temp.setName(_people.getUser_name());
            temp.setPhoto(_people.getUser_photo());
            temp.setDate(chat.get(i).getDate());
            temp.setTime(chat.get(i).getTime());
            temp.setSort_time(chat.get(i).getSort_time());
            temp.setPrev_chat(chat.get(i).getPrev_chat());
            temp.setSize(0L);
            temp.setUnread(prevChatRepository.countFlagChat(x, chat.get(i).getId()));
            chatgroup.add(temp);
        }

        for(int i = 0 ; i < group.size() ; i++)
        {
            ChatList temp = new ChatList();
            temp.setId_prev(group.get(i).getId_prev());
            temp.setName(group.get(i).getGroup_name());
            temp.setPhoto(group.get(i).getPhoto());
            temp.setDate(group.get(i).getDate());
            temp.setTime(group.get(i).getTime());
            temp.setSort_time(group.get(i).getSort_time());
            temp.setPrev_chat(group.get(i).getPrev_chat());
            temp.setSize(prevChatRepository.findCountMember(group.get(i).getId_prev()));
            temp.setUnread(prevChatRepository.countFlagGroup(x, group.get(i).getId_prev()));
            chatgroup.add(temp);
        }
        Collections.sort( chatgroup , ChatList.COMPARE_BY_SORT_TIME );
        return chatgroup ;
    }


    @DeleteMapping("/auth/deleteChatPrev/{id}")
    public boolean deleteChatPrev(@PathVariable(value = "id") Long id){
        PrevChat prevchat = prevChatRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
        prevChatRepository.delete(prevchat);
//        hapus chatnya juga . . .
        return true;
    }

}

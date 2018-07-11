package com.example.senyumdifabel.chat;

import com.example.senyumdifabel.ResourceNotFoundException;
import com.example.senyumdifabel.flagChat.FlagChat;
import com.example.senyumdifabel.flagChat.FlagChatRepository;
import com.example.senyumdifabel.params.Params;
import com.example.senyumdifabel.prevChat.PrevChat;
import com.example.senyumdifabel.prevChat.PrevChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ChatController {
    private ChatRepository chatRepository ;
    private PrevChatRepository prevChatRepository ;
    private FlagChatRepository flagChatRepository ;

    @Autowired
    public ChatController(ChatRepository chatRepository, PrevChatRepository prevChatRepository, FlagChatRepository flagChatRepository) {
        this.chatRepository = chatRepository;
        this.prevChatRepository = prevChatRepository;
        this.flagChatRepository = flagChatRepository;
    }

    @PostMapping("/auth/sendMessage")
    public Chat sendMessage(@RequestBody Chat chat){
        PrevChat prev = chatRepository.findPrev(chat.getId_prev());
        prev.setSort_time(chat.getSort_time());
        prev.setPrev_chat(chat.getMessage());
        prev.setDate(chat.getDate());
        prev.setTime(chat.getTime());
        prevChatRepository.save(prev);

        FlagChat flagChat = new FlagChat();
        flagChat.setId_prev(chat.getId_prev());
        flagChat.setFlag(false);
        flagChat.setType(1L);
        if(chat.getSender() == prev.getPeopleA())
            flagChat.setUser_id(prev.getPeopleB());
        else
            flagChat.setUser_id(prev.getPeopleB());
        flagChatRepository.save(flagChat);

        return chatRepository.save(chat);
    }

    @GetMapping("/auth/getChat/{id}")
    public Chat loadChat(@PathVariable(value ="id") Long x){
        return chatRepository.findById(x).orElseThrow(() -> new ResourceNotFoundException("Id " + x.toString() + " not found"));
    }

    @PostMapping("/auth/loadChat")
    public List<Chat> getChat(@RequestBody Params x){
        Long user_id = x.getParam1();
        Long id_prev = x.getParam2();
        List<FlagChat> flag = chatRepository.countFlagChat(user_id, id_prev);
        for(int i=0 ; i<flag.size() ; i++)
        {
            flag.get(i).setFlag(true);
            flagChatRepository.save(flag.get(i));
        }
        return chatRepository.loadChat(id_prev);
    }

    @DeleteMapping("/auth/deleteChat/{id}")
    public boolean deleteChat(@PathVariable(value = "id") Long id) {
        Chat people = chatRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
        chatRepository.delete(people);
        return true;
    }

}

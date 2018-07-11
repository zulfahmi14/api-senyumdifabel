package com.example.senyumdifabel.chat;

import com.example.senyumdifabel.ResourceNotFoundException;
import com.example.senyumdifabel.flagChat.FlagChat;
import com.example.senyumdifabel.flagChat.FlagChatRepository;
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

    @GetMapping("/auth/loadChat/{id}")
    public List<Chat> getChat(@PathVariable(value ="id") Long x){
        return chatRepository.loadChat(x);
    }

    @DeleteMapping("/auth/deleteChat/{id}")
    public boolean deleteChat(@PathVariable(value = "id") Long id) {
        Chat people = chatRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
        chatRepository.delete(people);
        return true;
    }

}

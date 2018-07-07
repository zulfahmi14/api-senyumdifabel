package com.example.senyumdifabel.chat;

import com.example.senyumdifabel.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChatController {
    private ChatRepository chatRepository ;

    @Autowired
    public ChatController(ChatRepository chatRepository){this.chatRepository = chatRepository;}

    @PostMapping("/auth/sendMessage")
    public Chat sendMessage(@RequestBody Chat chat){
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

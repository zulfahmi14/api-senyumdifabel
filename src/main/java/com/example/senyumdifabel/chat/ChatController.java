package com.example.senyumdifabel.chat;

import com.example.senyumdifabel.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ChatController {
    private ChatRepository chatRepository ;

    @Autowired
    public ChatController(ChatRepository chatRepository){this.chatRepository = chatRepository;}

    @PostMapping("/sendMessage")
    public Chat sendMessage(@RequestBody Chat chat){
        return chatRepository.save(chat);
    }

    @GetMapping("/loadChat/{id}")
    public Chat loadChat(@PathVariable(value ="id") Long x){
        return chatRepository.findById(x).orElseThrow(() -> new ResourceNotFoundException("Id " + x.toString() + " not found"));
    }


}

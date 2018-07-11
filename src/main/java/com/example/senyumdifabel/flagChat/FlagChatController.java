package com.example.senyumdifabel.flagChat;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class FlagChatController {
    private FlagChatRepository readRepository;

    @Autowired
    public FlagChatController(FlagChatRepository readRepository){
        this.readRepository = readRepository;
    }

    @GetMapping("/auth/getCountFlagChat/{id}")
    public Long getCountFlag(@PathVariable(value = "id") Long id){
        return readRepository.findCountFlag(id, false);
    }
    
}

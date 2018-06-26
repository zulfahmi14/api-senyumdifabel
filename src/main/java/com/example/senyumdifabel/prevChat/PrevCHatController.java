package com.example.senyumdifabel.prevChat;

import com.example.senyumdifabel.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PrevCHatController {
    private PrevChatRepository prevChatRepository ;

    @Autowired
    public PrevCHatController(PrevChatRepository prevChatRepository){ this.prevChatRepository = prevChatRepository ;}

    @PostMapping("/addChat")
    public PrevChat addChat(@RequestBody PrevChat prevChat){
        return prevChatRepository.save(prevChat);
    }

    @GetMapping("/listChat/{id}")
    public PrevChat listChat(@PathVariable(value ="id") Long x){
        return prevChatRepository.findMyChat(x);
    }

    @DeleteMapping("/deleteChat/{id}")
    public boolean deleteChat(@PathVariable(value = "id") Long id){
        PrevChat prevchat = prevChatRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
        prevChatRepository.delete(prevchat);
//        hapus chatnya juga . . .
        return true;
    }

}

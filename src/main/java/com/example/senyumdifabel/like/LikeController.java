package com.example.senyumdifabel.like;

import com.example.senyumdifabel.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LikeController {
    private LikeRepository likeRepository;

    public LikeController(LikeRepository likeRepository){
        this.likeRepository = likeRepository;
    }

    @PostMapping("/addLike")
    public Like addLike(@RequestBody Like like){
        return likeRepository.save(like);
    }

    @GetMapping("/getLike/{id}")
    public List<Like> getLike(@PathVariable(value = "id") Long id){
        return likeRepository.findLike(id) ;
    }


    @DeleteMapping("/deleteLike/{id}")
    public boolean deleteLike(@PathVariable(value = "id") Long id) {
        Like people = likeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
        likeRepository.delete(people);
        return true;
    }

}

package com.example.senyumdifabel.likes;

import com.example.senyumdifabel.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class LikesController {
    private LikesRepository likesRepository;

    @Autowired
    public LikesController(LikesRepository likesRepository){
        this.likesRepository = likesRepository;
    }

    @PostMapping("/addLikes")
    public Likes addLike(@RequestBody Likes like){
        return likesRepository.save(like);
    }

    @GetMapping("/getLikes/{id}")
    public List<Likes> getLike(@PathVariable(value = "id") Long id){
        return likesRepository.findLike(id) ;
    }


    @DeleteMapping("/deleteLikes/{id}")
    public boolean deleteLike(@PathVariable(value = "id") Long id) {
        Likes people = likesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
        likesRepository.delete(people);
        return true;
    }

}

package com.example.senyumdifabel.likes;

import com.example.senyumdifabel.params.Params;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class LikesController {
    private LikesRepository likesRepository;

    @Autowired
    public LikesController(LikesRepository likesRepository){
        this.likesRepository = likesRepository;
    }

    @PostMapping("/auth/addLikes")
    public Likes addLike(@RequestBody Likes like){
        return likesRepository.save(like);
    }

    @PostMapping("/auth/deleteLike")
    public boolean deleteLike(@RequestBody Params like){
        Long user_id = like.getParam1() ;
        Long timeline_id = like.getParam2() ;
        Likes del = likesRepository.findLikeUser(user_id , timeline_id);
        if(del == null) return false ;
        else
        {
            likesRepository.delete(del);
            return true ;
        }
    }

    @GetMapping("/auth/getLikes/{id}") // timeline_id
    public List<Likes> getLike(@PathVariable(value = "id") Long id){
        return likesRepository.findLike(id) ;
    }


//    @DeleteMapping("/deleteLikes/{id}")
//    public boolean deleteLike(@PathVariable(value = "id") Long id) {
//        Likes people = likesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
//        likesRepository.delete(people);
//        return true;
//    }

}

package com.example.senyumdifabel.following;

import com.example.senyumdifabel.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class FollowingController {
    private FollowingRepository followingRepository;

    @Autowired
    public FollowingController(FollowingRepository followingRepository){
        this.followingRepository = followingRepository;
    }

    @PostMapping("/follow")
    public Following addFollow(@RequestBody Following fol){
        return followingRepository.save(fol);
    }

//    @GetMapping("/getFollowings")
//    public List<Following> show(){
//        return followingRepository.findAll();
//    }

    @GetMapping("/getFollowing/{id}")
    public List<Following> findFollowing(@PathVariable(value = "id") Long id){
        return followingRepository.findFollowings(id) ;
    }

    @GetMapping("/getFollower/{id}")
    public List<Following> findFollower(@PathVariable(value = "id") Long id){
        return followingRepository.findFollowers(id) ;
    }

    @PutMapping("/updateFollowing/{id}")
    public Following updateFollowing(@PathVariable(value = "id") Long id, @RequestBody Following peoplenew){
        Following peopleold = followingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
        peopleold.setUser_id(peoplenew.getUser_id());
        peopleold.setFollow(peoplenew.getFollow());
        return followingRepository.save(peopleold);
    }

    @DeleteMapping("/deleteFollowing/{id}")
    public boolean deleteFollowing(@PathVariable(value = "id") Long id) {
        Following people = followingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
        followingRepository.delete(people);
        return true;
    }
}

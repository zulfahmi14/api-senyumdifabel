package com.example.senyumdifabel.follower;

import com.example.senyumdifabel.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FollowerController {
    private FollowerRepository followerRepository;

    @Autowired
    public FollowerController(FollowerRepository followerRepository){
        this.followerRepository = followerRepository;
    }

    @PostMapping("/follower")
    public Follower addFollow(@RequestBody Follower fol){
        return followerRepository.save(fol);
    }

//    @GetMapping("/getFollowings")
//    public List<Following> show(){
//        return followingRepository.findAll();
//    }

    @GetMapping("/getFollower/{id}")
    public List<Follower> findFollower(@PathVariable(value = "id") Long id){
        return followerRepository.findFollower(id) ;
    }

    @PutMapping("/updateFollower/{id}")
    public Follower updateFollower(@PathVariable(value = "id") Long id, @RequestBody Follower peoplenew){
        Follower peopleold = followerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
        peopleold.setUser_id(peoplenew.getUser_id());
        peopleold.setFollower(peoplenew.getFollower());
        return followerRepository.save(peopleold);
    }

    @DeleteMapping("/deleteFollower/{id}")
    public boolean deleteFollowing(@PathVariable(value = "id") Long id) {
        Follower people = followerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
        followerRepository.delete(people);
        return true;
    }
}

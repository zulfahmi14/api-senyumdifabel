package com.example.senyumdifabel.follower;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class FollowerController {
    private FollowerRepository followerRepository;

    @Autowired
    public FollowerController(FollowerRepository followerRepository){
        this.followerRepository = followerRepository;
    }

//    @PostMapping("/auth/follower")
//    public Follower addFollow(@RequestBody Follower fol){
//        return followerRepository.save(fol);
//    }
//
//    @GetMapping("/getFollowings")
//    public List<Following> show(){
//        return followingRepository.findAll();
//    }
//
//    @GetMapping("/auth/getFollower/{id}")
//    public List<Follower> findFollower(@PathVariable(value = "id") Long id){
//        return followerRepository.findFollower(id) ;
//    }
//
//    @PutMapping("/auth/updateFollower/{id}")
//    public Follower updateFollower(@PathVariable(value = "id") Long id, @RequestBody Follower peoplenew){
//        Follower peopleold = followerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
//        peopleold.setUser_id(peoplenew.getUser_id());
//        peopleold.setFollower(peoplenew.getFollower());
//        return followerRepository.save(peopleold);
//    }
//
//    @DeleteMapping("/auth/deleteFollower/{id}")
//    public boolean deleteFollowing(@PathVariable(value = "id") Long id) {
//        Follower people = followerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
//        followerRepository.delete(people);
//        return true;
//    }
}

package com.example.senyumdifabel.following;

import com.example.senyumdifabel.ResourceNotFoundException;
import com.example.senyumdifabel.params.NamePhoto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class FollowingController {
    private FollowingRepository followingRepository;

    @Autowired
    public FollowingController(FollowingRepository followingRepository){
        this.followingRepository = followingRepository;
    }

    @PostMapping("/auth/following")
    public Following addFollow(@RequestBody Following fol){
        return followingRepository.save(fol);
    }

    @GetMapping("/auth/getFollowings")
    public List<Following> show(){
        return followingRepository.findAll();
    }

    @GetMapping("/auth/getFollowing/{id}")
    public List<NamePhoto> findFollowing(@PathVariable(value = "id") Long id){
        List<NamePhoto> send = new ArrayList<NamePhoto>();
        List<Following> c = followingRepository.findFollowing(id);
        for(int i = 0 ; i < c.size() ; i++)
        {
            Long idx = c.get(i).getFollow();
            NamePhoto temp = new NamePhoto();
            temp.setUser_id(c.get(i).getUser_id());
            temp.setUser_name(followingRepository.findUserName(idx));
            temp.setUser_photo(followingRepository.findUserPhoto(idx));
            send.add(temp);
        }
        return send;
    }

    @GetMapping("/auth/getFollower/{id}")
    public List<NamePhoto> findFollower(@PathVariable(value = "id") Long id){
        List<NamePhoto> send = new ArrayList<NamePhoto>();
        List<Following> c = followingRepository.findFollower(id);
        for(int i = 0 ; i < c.size() ; i++)
        {
            Long idx = c.get(i).getFollow();
            NamePhoto temp = new NamePhoto();
            temp.setUser_id(c.get(i).getUser_id());
            temp.setUser_name(followingRepository.findUserName(idx));
            temp.setUser_photo(followingRepository.findUserPhoto(idx));
            send.add(temp);
        }
        return send;
    }

    @PutMapping("/auth/updateFollowing/{id}")
    public Following updateFollowing(@PathVariable(value = "id") Long id, @RequestBody Following peoplenew){
        Following peopleold = followingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
        peopleold.setUser_id(peoplenew.getUser_id());
        peopleold.setFollow(peoplenew.getFollow());
        return followingRepository.save(peopleold);
    }

    @DeleteMapping("/auth/deleteFollowing/{id}")
    public boolean deleteFollowing(@PathVariable(value = "id") Long id) {
        Following people = followingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
        followingRepository.delete(people);
        return true;
    }
}
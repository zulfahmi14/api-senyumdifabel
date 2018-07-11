package com.example.senyumdifabel.following;

import com.example.senyumdifabel.ResourceNotFoundException;
import com.example.senyumdifabel.params.NamePhoto;
import com.example.senyumdifabel.params.Params;
import com.example.senyumdifabel.people.People;
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
            People x = followingRepository.findPeople(idx);
            temp.setUser_id(idx);
            temp.setUser_name(x.getUser_name());
            temp.setUser_photo(x.getUser_photo());
            temp.setUser_job(x.getUser_job());
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
            Long idx = c.get(i).getUser_id();
            NamePhoto temp = new NamePhoto();
            People x = followingRepository.findPeople(idx);
            temp.setUser_id(idx);
            temp.setUser_photo(x.getUser_photo());
            temp.setUser_job(x.getUser_job());
            temp.setUser_name(x.getUser_name());
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

    @PostMapping("/auth/deleteFollowing")
    public boolean deleteuser(@RequestBody Params x) {
        Long x1 = x.getParam1() ;
        Long x2 = x.getParam2() ;
        Following leave = followingRepository.findDelete(x1,x2);
        if(leave == null)
        {
            return false ;
        }
        else
        {
            followingRepository.delete(leave);
            return true ;
        }

    }
}
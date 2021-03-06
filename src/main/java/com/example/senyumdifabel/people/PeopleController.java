package com.example.senyumdifabel.people;
import com.example.senyumdifabel.ResourceNotFoundException;
import com.example.senyumdifabel.params.CountFollow;
import com.example.senyumdifabel.prevGroup.PrevGroup;
import com.example.senyumdifabel.user.Authorities;
import com.example.senyumdifabel.user.AuthoritiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class PeopleController {
    private PeopleRepository peopleRepository;
    private AuthoritiesRepository authoritiesRepository ;

    @Autowired
    public PeopleController(PeopleRepository peopleRepository, AuthoritiesRepository authoritiesRepository) {
        this.peopleRepository = peopleRepository;
        this.authoritiesRepository = authoritiesRepository;
    }

    @PostMapping("/register")
    public People register(@RequestBody People people){
        people.setUser_password(new BCryptPasswordEncoder().encode(people.getUser_password()));
        List<People> email = peopleRepository.findEmail(people.getUser_email());
        if( email.size()  < 1 )
        {
            peopleRepository.save(people);
            Authorities authorities = new Authorities(people.getUser_email(), people);
            authoritiesRepository.save(authorities);
            return people ;
        }
        else
        {
            people.setUser_name("email sudah ada");
            return people ;
        }

    }
    @PostMapping("/auth/login")
    public People login(@RequestBody People people){
        return peopleRepository.findemail(people.getUser_email());
    }

    @GetMapping("/auth/getusers")
    public List<People> show(){
        return peopleRepository.findAll();
    }

    @GetMapping("/auth/getuser/{id}")
    public People getuser(@PathVariable(value = "id") Long id){
        return peopleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
    }

    @GetMapping("/auth/myGroup/{id}")
    public List<PrevGroup> myGroup(@PathVariable(value = "id") Long id){
        return peopleRepository.findMyGroup(id);
    }

    @PutMapping("/auth/update/{id}")
    public People updateuser(@PathVariable(value = "id") Long id, @RequestBody People peoplenew){
        People peopleold = peopleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
        peopleold.setUser_name(peoplenew.getUser_name());
//        peopleold.setUser_email(peoplenew.getUser_email());
//        peopleold.setUser_password(peoplenew.getUser_password());
        peopleold.setUser_address(peoplenew.getUser_address());
        peopleold.setUser_contact(peoplenew.getUser_contact());     //contact buat bio
        peopleold.setUser_photo(peoplenew.getUser_photo());
        return peopleRepository.save(peopleold);
    }
    @PutMapping("/auth/updatecv/{id}")
    public People updatecv(@PathVariable(value = "id") Long id, @RequestBody People peoplenew){
        People peopleold = peopleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
        peopleold.setCv(peoplenew.getCv());
        return peopleRepository.save(peopleold);
    }

    @PutMapping("/auth/updatephoto/{id}")
    public People updatephoto(@PathVariable(value = "id") Long id, @RequestBody People peoplenew){
        People peopleold = peopleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
        peopleold.setUser_photo(peoplenew.getUser_photo());
        return peopleRepository.save(peopleold);
    }

    @DeleteMapping("/auth/deleteuser/{id}")
    public boolean deleteuser(@PathVariable(value = "id") Long id) {
        People people = peopleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
        peopleRepository.delete(people);
        return true;
    }

    //count profile
    @GetMapping("/auth/countFollow/{id}")
    public CountFollow countFollow(@PathVariable(value = "id") Long id){
        Long countFollowing = peopleRepository.findConFollowing(id);
        Long countFollower = peopleRepository.findConFollower(id);

        CountFollow cot = new CountFollow();
        cot.setFollower(countFollower);
        cot.setFollowing(countFollowing);
        return cot;
    }

    //buat page profile, pake gabungan beberapa API ajaa
//    @GetMapping("/Profile/{id}")
//    public ProfileUser profile(@PathVariable(value = "id") Long id){
//        ProfileUser p = peopleRepository.findProfile(id);
//
//        List<Experience> ex = peopleRepository.findExperience(id);
//        for (int i = 0; i<ex.size(); i++){
//           p.setExperiences();
//        }
//         p.setExperiences(ex);
//
//        List<Education> ed = peopleRepository.findEducation(id);
//        p.setEducations(ed);
//
//        List<Skill> sk = peopleRepository.findSkill(id);
//        p.setSkills(sk);
//
//        List<Achievement> ac = peopleRepository.findAchievement(id);
//        p.setAchievements(ac);
//
//        List<Contact> co = peopleRepository.findContact(id);
//        p.setContacts(co);

//        return p;
//    }

}
/*
{
    "user_password": "$2a$10$UurEiOTKbq2HPsAVa8bMrusdpF/Xw6PV3r.GLpkgrRNCYISD97UL.",
    "user_address": null,
    "user_photo": null,
    "user_contact": null,
    "cv": "zull"
}
 */


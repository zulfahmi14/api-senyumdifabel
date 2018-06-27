package com.example.senyumdifabel.people;
import com.example.senyumdifabel.ResourceNotFoundException;
import com.example.senyumdifabel.prevGroup.PrevGroup;
import com.example.senyumdifabel.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PeopleController {
    private PeopleRepository peopleRepository;

    @Autowired
    public PeopleController(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @PostMapping("/register")
    public People register(@RequestBody People people){
        return peopleRepository.save(people);
    }

    @PostMapping("/login")
    public People login(@RequestBody People people){
        return peopleRepository.login(people.getUser_name() , people.getUser_name()) ;
    }

    @GetMapping("/getusers")
    public List<People> show(){
        return peopleRepository.findAll();
    }

    @GetMapping("/getuser/{id}")
    public People getuser(@PathVariable(value = "id") Long id){
        return peopleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
    }

    @GetMapping("/myGroup/{id}")
    public List<PrevGroup> myGroup(@PathVariable(value = "id") Long id){
        return peopleRepository.findMyGroup(id);
    }

    @PutMapping("/update/{id}")
    public People updateuser(@PathVariable(value = "id") Long id, @RequestBody People peoplenew){
        People peopleold = peopleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
        peopleold.setUser_name(peoplenew.getUser_name());
        peopleold.setUser_email(peoplenew.getUser_email());
        peopleold.setUser_password(peoplenew.getUser_password());
        peopleold.setUser_address(peoplenew.getUser_address());
        peopleold.setUser_contact(peoplenew.getUser_contact());
//        peopleold.setUser_photo(peoplenew.getUser_photo());
        return peopleRepository.save(peopleold);
    }
    @PutMapping("/updatecv/{id}")
    public People updatecv(@PathVariable(value = "id") Long id, @RequestBody People peoplenew){
        People peopleold = peopleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
        peopleold.setCv(peoplenew.getCv());
        return peopleRepository.save(peopleold);
    }

    @PutMapping("/updatephoto/{id}")
    public People updatephoto(@PathVariable(value = "id") Long id, @RequestBody People peoplenew){
        People peopleold = peopleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
        peopleold.setUser_photo(peoplenew.getUser_photo());
        return peopleRepository.save(peopleold);
    }

    @DeleteMapping("/deleteuser/{id}")
    public boolean deleteuser(@PathVariable(value = "id") Long id) {
        People people = peopleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
        peopleRepository.delete(people);
        return true;
    }

}
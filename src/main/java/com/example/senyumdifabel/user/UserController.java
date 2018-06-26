package com.example.senyumdifabel.user;

import com.example.senyumdifabel.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @PostMapping("/registerz")
//    public User register(@RequestBody User user){
//        return userRepository.save(user);
//    }
//
//    @GetMapping("/getusers")
//    public List<User> show(){
//        return userRepository.findAll();
//    }
//
//    @GetMapping("/getuser/{id}")
//    public User getuser(@PathVariable(value = "id") Long id){
//        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
//    }
//
//    @PutMapping("/updateuser/{id}")
//    public User updateuser(@PathVariable(value = "id") Long id, @RequestBody User usernew){
//        User userold = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
//        userold.setUser_name(usernew.getUser_name());
//        userold.setUser_email(usernew.getUser_email());
//        userold.setUser_password(usernew.getUser_password());
//        return userRepository.save(userold);
//    }
//
//    @DeleteMapping("/deleteuser/{id}")
//    public boolean deleteuser(@PathVariable(value = "id") Long id){
//        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
//        userRepository.delete(user);
//        return true;
//    }
}

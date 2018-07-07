package com.example.senyumdifabel.achievement;

import com.example.senyumdifabel.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class AchievementController {
    private AchievementRepository achievementRepository ;

    @Autowired
    public AchievementController(AchievementRepository achievementRepository) {
        this.achievementRepository = achievementRepository;
    }

    @PostMapping("/auth/addAchievement")
    public Achievement addAchievement(@RequestBody Achievement achi){
        return achievementRepository.save(achi);
    }

    @GetMapping("/auth/getAchievement/{id}")
    public List<Achievement> getAchi(@PathVariable(value = "id") Long id){
        return achievementRepository.findAchi(id) ;
    }

    @PutMapping("/auth/updateAchievement/{id}")
    public Achievement updatecv(@PathVariable(value = "id") Long id, @RequestBody Achievement peoplenew){
        Achievement peopleold = achievementRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
        peopleold.setAchivement(peoplenew.getAchivement());
        peopleold.setForm(peoplenew.getForm());
        peopleold.setYear(peoplenew.getYear());
//        peopleold.setUser_id(peoplenew.getUser_id());
        return achievementRepository.save(peopleold);
    }

    @DeleteMapping("/auth/deleteAchievement/{id}")
    public boolean deleteuser(@PathVariable(value = "id") Long id) {
        Achievement people = achievementRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
        achievementRepository.delete(people);
        return true;
    }
}

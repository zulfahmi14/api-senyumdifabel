package com.example.senyumdifabel.skill;


import com.example.senyumdifabel.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class SkillController {
    private SkillRepository skillRepository ;

    public SkillController(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    @PostMapping("/auth/addSkill")
    public Skill addSkill(@RequestBody Skill edu){
        return skillRepository.save(edu);
    }

    @GetMapping("/auth/getSkill/{id}")
    public List<Skill> getEdu(@PathVariable(value = "id") Long id){
        return skillRepository.findSkill(id) ;
    }

    @PutMapping("/auth/updateSkill/{id}")
    public Skill updatecv(@PathVariable(value = "id") Long id, @RequestBody Skill peoplenew){
        Skill peopleold = skillRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
        peopleold.setSkill(peoplenew.getSkill());
        return skillRepository.save(peopleold);
    }

    @DeleteMapping("/auth/deleteSkill/{id}")
    public boolean deleteuser(@PathVariable(value = "id") Long id) {
        Skill people = skillRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
        skillRepository.delete(people);
        return true;
    }
}

package com.example.senyumdifabel.experience;

import com.example.senyumdifabel.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ExperienceController {
    private ExperienceRepository experienceRepository ;

    @Autowired
    public ExperienceController(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    @PostMapping("/auth/addExperience")
    public Experience addExperience(@RequestBody Experience ex){
        return experienceRepository.save(ex);
    }

    @GetMapping("/auth/getExperience/{id}")
    public List<Experience> getEdu(@PathVariable(value = "id") Long id){
        return experienceRepository.findExp(id) ;
    }

    @PutMapping("/auth/updateExperience/{id}")
    public Experience updateExperience(@PathVariable(value = "id") Long id, @RequestBody Experience peoplenew){
        Experience peopleold = experienceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
        peopleold.setTitle(peoplenew.getTitle());
        peopleold.setDescription(peoplenew.getDescription());
        peopleold.setYear(peoplenew.getYear());
        return experienceRepository.save(peopleold);
    }

    @DeleteMapping("/auth/deleteExperience/{id}")
    public boolean deleteuser(@PathVariable(value = "id") Long id) {
        Experience people = experienceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
        experienceRepository.delete(people);
        return true;
    }
}

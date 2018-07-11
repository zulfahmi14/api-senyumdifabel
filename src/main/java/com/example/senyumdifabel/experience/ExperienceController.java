package com.example.senyumdifabel.experience;

import com.example.senyumdifabel.ResourceNotFoundException;
import com.example.senyumdifabel.people.People;
import com.example.senyumdifabel.people.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ExperienceController {
    private ExperienceRepository experienceRepository ;
    private PeopleRepository peopleRepository ;

    @Autowired
    public ExperienceController(ExperienceRepository experienceRepository, PeopleRepository peopleRepository) {
        this.experienceRepository = experienceRepository;
        this.peopleRepository = peopleRepository;
    }

    @PostMapping("/auth/addExperience")
    public Experience addExperience(@RequestBody Experience ex){
        People people = experienceRepository.findUser(ex.getUser_id()) ;
        people.setUser_job(ex.getTitle());
        peopleRepository.save(people);
        return experienceRepository.save(ex);
    }

    @GetMapping("/auth/getExperience/{id}")
    public List<Experience> getExperience(@PathVariable(value = "id") Long id){
        return experienceRepository.findExp(id);
    }

    @GetMapping("/auth/getJob/{id}")
    public Experience getJob(@PathVariable(value = "id") Long id){
         List<Experience> List = experienceRepository.findJob(id);
         Experience job = List.get(0);
         return job;
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

package com.example.senyumdifabel.education;

import com.example.senyumdifabel.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EducationController {
    private EducationRepository educationRepository ;

    @Autowired
    public EducationController(EducationRepository educationRepository) {
        this.educationRepository = educationRepository;
    }

    @PostMapping("/auth/addEducation")
    public Education addEducation(@RequestBody Education edu){
        return educationRepository.save(edu);
    }

    @GetMapping("/auth/getEducation/{id}")
    public List<Education> getEdu(@PathVariable(value = "id") Long id){
        return educationRepository.findEdu(id) ;
    }

    @PutMapping("/auth/updateEducation/{id}")
    public Education updatecv(@PathVariable(value = "id") Long id, @RequestBody Education peoplenew){
        Education peopleold = educationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
        peopleold.setSchool(peoplenew.getSchool());
        peopleold.setMajor(peoplenew.getMajor());
        peopleold.setYear(peoplenew.getYear());
        return educationRepository.save(peopleold);
    }

    @DeleteMapping("/auth/deleteEducation/{id}")
    public boolean deleteuser(@PathVariable(value = "id") Long id) {
        Education people = educationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
        educationRepository.delete(people);
        return true;
    }
}

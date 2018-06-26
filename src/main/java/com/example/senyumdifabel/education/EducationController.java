package com.example.senyumdifabel.education;

import com.example.senyumdifabel.ResourceNotFoundException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class EducationController {
    private EducationRepository educationRepository ;

    public EducationController(EducationRepository educationRepository) {
        this.educationRepository = educationRepository;
    }

    @PostMapping("/addEducation")
    public Education addEducation(@RequestBody Education edu){
        return educationRepository.save(edu);
    }

    @GetMapping("/getEducation/{id}")
    public List<Education> getEdu(@PathVariable(value = "id") Long id){
        return educationRepository.findEdu(id) ;
    }

    @PutMapping("/updateEducation/{id}")
    public Education updatecv(@PathVariable(value = "id") Long id, @RequestBody Education peoplenew){
        Education peopleold = educationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
        peopleold.setSchool(peoplenew.getSchool());
        peopleold.setMajor(peoplenew.getMajor());
        peopleold.setYear(peoplenew.getYear());
        return educationRepository.save(peopleold);
    }

    @DeleteMapping("/deleteEducation/{id}")
    public boolean deleteuser(@PathVariable(value = "id") Long id) {
        Education people = educationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
        educationRepository.delete(people);
        return true;
    }
}

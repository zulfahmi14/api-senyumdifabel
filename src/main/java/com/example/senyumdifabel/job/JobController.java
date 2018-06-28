package com.example.senyumdifabel.job;

import com.example.senyumdifabel.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {
    private JobRepository jobRepository ;

    @Autowired
    public JobController(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @PostMapping("/addJob")
    public Job addJob(@RequestBody Job edu){
        return jobRepository.save(edu);
    }

    @GetMapping("/getjobs")
    public List<Job> show(){
        return jobRepository.findAll();
    }

    @GetMapping("/getJob/{id}")
    public List<Job> getEdu(@PathVariable(value = "id") Long id){
        return jobRepository.findJob(id) ;
    }

    @PutMapping("/updateJob/{id}")
    public Job updatecv(@PathVariable(value = "id") Long id, @RequestBody Job peoplenew){
        Job peopleold = jobRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
        peopleold.setDescription(peoplenew.getDescription());
        return jobRepository.save(peopleold);
    }

    @DeleteMapping("/deleteJob/{id}")
    public boolean deleteuser(@PathVariable(value = "id") Long id) {
        Job people = jobRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
        jobRepository.delete(people);
        return true;
    }
}

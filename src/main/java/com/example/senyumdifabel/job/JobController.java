package com.example.senyumdifabel.job;

import com.example.senyumdifabel.ResourceNotFoundException;
import com.example.senyumdifabel.params.JobCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class JobController {
    private JobRepository jobRepository ;

    @Autowired
    public JobController(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @PostMapping("/auth/addJob")
    public Job addJob(@RequestBody Job edu){
        return jobRepository.save(edu);
    }

    @GetMapping("/auth/getjobs")
    public List<JobCompany> show(){
        List<JobCompany> send = new ArrayList<JobCompany>();
        List<Job> c = jobRepository.findAll();
        for(int i = 0 ; i < c.size() ; i++)
        {
            Long idx = c.get(i).getCompany_id();
            JobCompany temp = new JobCompany() ;
            temp.setCompany_name(jobRepository.findCompanyName(idx));
            temp.setJob_id(c.get(i).getJob_id());
            temp.setDate(c.get(i).getDate());
            temp.setTime(c.get(i).getTime());
            temp.setName(c.get(i).getName());
            temp.setDescription(c.get(i).getDescription());
            temp.setCompany_id(c.get(i).getCompany_id());
            send.add(temp);
        }
        return send;
    }

//    @GetMapping("/getJob/{id}")
//    public List<Job> getEdu(@PathVariable(value = "id") Long id){
//        return jobRepository.findJob(id) ;
//    }

    @PutMapping("/auth/updateJob/{id}")
    public Job updatecv(@PathVariable(value = "id") Long id, @RequestBody Job peoplenew){
        Job peopleold = jobRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
        peopleold.setDescription(peoplenew.getDescription());
        return jobRepository.save(peopleold);
    }

    @DeleteMapping("/auth/deleteJob/{id}")
    public boolean deleteuser(@PathVariable(value = "id") Long id) {
        Job people = jobRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
        jobRepository.delete(people);
        return true;
    }
}

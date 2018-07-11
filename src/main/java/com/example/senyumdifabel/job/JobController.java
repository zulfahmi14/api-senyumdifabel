package com.example.senyumdifabel.job;

import com.example.senyumdifabel.ResourceNotFoundException;
import com.example.senyumdifabel.bookmark.Bookmark;
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

    @GetMapping("/auth/getjobs/{id}")   //id user
    public List<JobCompany> show(@PathVariable(value = "id") Long id){
        List<JobCompany> send = new ArrayList<JobCompany>();
        List<Job> c = jobRepository.findAll();
        List<Bookmark> mark = jobRepository.findBookmark(id);
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

            //bookmark
            temp.setFlag_bookmark(0L);
            for (int j = 0; j < mark.size() ; j++){
                if(c.get(i).getJob_id() == mark.get(j).getJob_id()){
                    temp.setFlag_bookmark(1L);
                    break;
                }
                else{
                    temp.setFlag_bookmark(0L);
                }
            }

            send.add(temp);
        }
        return send;
    }

    @GetMapping("/auth/getjobdetail/{id}") // job_id
    public JobCompany getEdu(@PathVariable(value = "id") Long id){
        Job job = jobRepository.findJob(id) ;
        JobCompany send = new JobCompany();
        send.setCompany_name(jobRepository.findCompanyName(job.getCompany_id()));
        send.setJob_id(job.getJob_id());
        send.setDate(job.getDate());
        send.setTime(job.getTime());
        send.setName(job.getName());
        send.setDescription(job.getDescription());
        send.setCompany_id(job.getCompany_id());

        return send;
    }

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

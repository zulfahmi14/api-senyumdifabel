package com.example.senyumdifabel.proposal;

import com.example.senyumdifabel.ResourceNotFoundException;
import com.example.senyumdifabel.bookmark.Bookmark;
import com.example.senyumdifabel.job.Job;
import com.example.senyumdifabel.params.CountJob;
import com.example.senyumdifabel.params.JobCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProposalController {
    private ProposalRepository proposalRepository ;

    @Autowired
    public ProposalController(ProposalRepository proposalRepository) {
        this.proposalRepository = proposalRepository;
    }

    @PostMapping("/auth/addProposal")
    public Proposal addProposal(@RequestBody Proposal edu){
        return proposalRepository.save(edu);
    }

    @GetMapping("/auth/getProposalByCompany/{id}")
    public List<Proposal> getProposalByCompany(@PathVariable(value = "id") Long id){
        return proposalRepository.findByCompany(id) ;
    }

    @GetMapping("/auth/getProposalByPeople/{id}")
    public List<Proposal> getProposalByPeople(@PathVariable(value = "id") Long id){
        return proposalRepository.findByUser(id) ;
    }

    //status = 1, Applied job
    @GetMapping("/auth/getApplied/{id}") // user id
    public List<JobCompany> getApplied(@PathVariable(value = "id") Long id){
        List<JobCompany> send = new ArrayList<JobCompany>();
        List<Proposal> c = proposalRepository.findAppliedJob(id);
        for(int i = 0 ; i < c.size() ; i++)
        {
            Long idx = c.get(i).getJob_id();
            Job job = proposalRepository.findJob(idx);
            JobCompany temp = new JobCompany() ;
            temp.setName(job.getName());
            temp.setCompany_id(job.getCompany_id());
            temp.setDate(job.getDate());
            temp.setTime(job.getTime());
            temp.setDescription(job.getDescription());
            temp.setJob_id(c.get(i).getJob_id());
            temp.setName(job.getName());
            temp.setCompany_name(proposalRepository.findCompanyName(job.getCompany_id()));
            send.add(temp);
        }
        return send;
    }

    //status = 2, Interview
    @GetMapping("/auth/getInterview/{id}") //user id
    public List<JobCompany> getInterview(@PathVariable(value = "id") Long id){
        List<JobCompany> send = new ArrayList<JobCompany>();
        List<Proposal> c = proposalRepository.findInterview(id);
        for(int i = 0 ; i < c.size() ; i++)
        {
            Long idx = c.get(i).getJob_id();
            Job job = proposalRepository.findJob(idx);
            JobCompany temp = new JobCompany() ;
            temp.setName(job.getName());
            temp.setCompany_id(job.getCompany_id());
            temp.setDate(job.getDate());
            temp.setTime(job.getTime());
            temp.setDescription(job.getDescription());
            temp.setJob_id(c.get(i).getJob_id());
            temp.setName(job.getName());
            temp.setCompany_name(proposalRepository.findCompanyName(job.getCompany_id()));
            send.add(temp);
        }
        return send;
    }

    //status =3, Failed job
    @GetMapping("/auth/getFailed/{id}")
    public List<JobCompany> getFailed(@PathVariable(value = "id") Long id){
        List<JobCompany> send = new ArrayList<JobCompany>();
        List<Proposal> c = proposalRepository.findFailed(id);
        for(int i = 0 ; i < c.size() ; i++)
        {
            Long idx = c.get(i).getJob_id();
            Job job = proposalRepository.findJob(idx);
            JobCompany temp = new JobCompany() ;
            temp.setName(job.getName());
            temp.setCompany_id(job.getCompany_id());
            temp.setDate(job.getDate());
            temp.setTime(job.getTime());
            temp.setDescription(job.getDescription());
            temp.setJob_id(c.get(i).getJob_id());
            temp.setName(job.getName());
            temp.setCompany_name(proposalRepository.findCompanyName(job.getCompany_id()));
            send.add(temp);
        }
        return send;
    }


    @GetMapping("/auth/countJob/{id}")
    public CountJob countJob(@PathVariable(value = "id") Long id){
        Long countBookmark = proposalRepository.countBookmark(id);
        Long countAppliedJob = proposalRepository.countAppliedJob(id);
        Long countInterview = proposalRepository.countInterview(id);
        Long countFailed = proposalRepository.countFailed(id);

        CountJob counter = new CountJob(countBookmark, countAppliedJob, countInterview, countFailed);
        return counter;

    }

    //BOokmark
    @GetMapping("/auth/getBookmark/{id}")
    public List<JobCompany> getBookmark(@PathVariable(value = "id") Long id){
        List<JobCompany> send = new ArrayList<JobCompany>();
        List<Bookmark> c = proposalRepository.findBookmark(id);
        for(int i = 0 ; i < c.size() ; i++)
        {
            Long idx = c.get(i).getJob_id();
            Job job = proposalRepository.findJob(idx);
            JobCompany temp = new JobCompany() ;
            temp.setName(job.getName());
            temp.setCompany_id(job.getCompany_id());
            temp.setDate(job.getDate());
            temp.setTime(job.getTime());
            temp.setDescription(job.getDescription());
            temp.setJob_id(c.get(i).getJob_id());
            temp.setName(job.getName());
            temp.setCompany_name(proposalRepository.findCompanyName(job.getCompany_id()));
            send.add(temp);
        }
        return send;
    }



    @PutMapping("/confirmProposal/{id}")
    public Proposal updatecv(@PathVariable(value = "id") Long id, @RequestBody Proposal peoplenew){
        Proposal peopleold = proposalRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
        peopleold.setStatus(peoplenew.getStatus());
        return proposalRepository.save(peopleold);
    }

    @DeleteMapping("/auth/deleteProposal/{id}")
    public boolean deleteuser(@PathVariable(value = "id") Long id) {
        Proposal people = proposalRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
        proposalRepository.delete(people);
        return true;
    }
}

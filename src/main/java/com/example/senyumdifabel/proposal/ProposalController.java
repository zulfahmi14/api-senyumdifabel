package com.example.senyumdifabel.proposal;

import com.example.senyumdifabel.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProposalController {
    private ProposalRepository proposalRepository ;

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

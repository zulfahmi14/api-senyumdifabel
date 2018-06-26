package com.example.senyumdifabel.proposal;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProposalController {
    private ProposalRepository proposalRepository ;

    public ProposalController(ProposalRepository proposalRepository) {
        this.proposalRepository = proposalRepository;
    }
}

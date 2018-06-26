package com.example.senyumdifabel.job;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobController {
    private JobRepository jobRepository ;

    public JobController(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

}

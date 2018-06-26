package com.example.senyumdifabel.education;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class EducationController {
    private EducationRepository educationRepository ;

    public EducationController(EducationRepository educationRepository) {
        this.educationRepository = educationRepository;
    }
}

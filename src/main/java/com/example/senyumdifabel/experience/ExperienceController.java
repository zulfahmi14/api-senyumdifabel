package com.example.senyumdifabel.experience;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExperienceController {
    private ExperienceRepository experienceRepository ;

    public ExperienceController(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }
}

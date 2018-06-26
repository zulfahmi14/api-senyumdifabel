package com.example.senyumdifabel.skill;


import org.springframework.web.bind.annotation.RestController;

@RestController
public class SkillController {
    private SkillRepository skillRepository ;

    public SkillController(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

}

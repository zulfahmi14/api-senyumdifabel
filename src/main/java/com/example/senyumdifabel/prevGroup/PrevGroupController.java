package com.example.senyumdifabel.prevGroup;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrevGroupController {
    private PrevGroupRepository prevGroupRepository;

    public PrevGroupController(PrevGroupRepository prevGroupRepository) {
        this.prevGroupRepository = prevGroupRepository;
    }

    @PostMapping("/createGroup")
    public PrevGroup createGroup(@RequestBody PrevGroup prevGroup){
        return prevGroupRepository.save(prevGroup);
    }

}

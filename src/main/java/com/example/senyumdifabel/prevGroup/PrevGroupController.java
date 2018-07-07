package com.example.senyumdifabel.prevGroup;

import com.example.senyumdifabel.people.People;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class PrevGroupController {
    private PrevGroupRepository prevGroupRepository;

    public PrevGroupController(PrevGroupRepository prevGroupRepository) {
        this.prevGroupRepository = prevGroupRepository;
    }

    @PostMapping("/auth/createGroup")
    public PrevGroup createGroup(@RequestBody PrevGroup prevGroup){
        return prevGroupRepository.save(prevGroup);
    }

    @GetMapping("/auth/groupMember/{id}")
    public List<People> myGroup(@PathVariable(value = "id") Long id){
        return prevGroupRepository.findMember(id);
    }

}

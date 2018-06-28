package com.example.senyumdifabel.prevGroup;

import com.example.senyumdifabel.ResourceNotFoundException;
import com.example.senyumdifabel.people.People;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/groupMember/{id}")
    public List<People> myGroup(@PathVariable(value = "id") Long id){
        return prevGroupRepository.findMember(id);
    }

}

package com.example.senyumdifabel.comment;

import com.example.senyumdifabel.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CommentController {
    private CommentRepository commentRepository ;

    public CommentController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @PostMapping("/addComment")
    public Comment addComment(@RequestBody Comment com){
        return commentRepository.save(com);
    }

    @GetMapping("/getComment/{id}")
    public List<Comment> getEdu(@PathVariable(value = "id") Long id){
        return commentRepository.findCom(id) ;
    }

    @PutMapping("/updateComment/{id}")
    public Comment updateCom(@PathVariable(value = "id") Long id, @RequestBody Comment peoplenew){
        Comment peopleold = commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
        peopleold.setComment(peoplenew.getComment());
        peopleold.setDate(peoplenew.getDate());
        peopleold.setTime(peoplenew.getTime());
        return commentRepository.save(peopleold);
    }

    @DeleteMapping("/deleteComment/{id}")
    public boolean deleteuser(@PathVariable(value = "id") Long id) {
        Comment people = commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
        commentRepository.delete(people);
        return true;
    }
}
package com.example.senyumdifabel.comment;

import com.example.senyumdifabel.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {
    private CommentRepository commentRepository ;

    @Autowired
    public CommentController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @PostMapping("/addComment")
    public Comment addComment(@RequestBody Comment com){
        return commentRepository.save(com);
    }

    @GetMapping("/getComment/{id}")
    public Long getComment(@PathVariable(value = "id") Long id){
        return commentRepository.findCom(id) ;
    }

    @GetMapping("/countComment/{id}")
    public Long countComment(@PathVariable(value = "id") Long id){
        return commentRepository.countCom(id) ;
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

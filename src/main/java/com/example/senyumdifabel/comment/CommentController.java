package com.example.senyumdifabel.comment;

import com.example.senyumdifabel.ResourceNotFoundException;
import com.example.senyumdifabel.params.CommentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CommentController {
    private CommentRepository commentRepository ;

    @Autowired
    public CommentController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @PostMapping("/auth/addComment")
    public Comment addComment(@RequestBody Comment com){
        return commentRepository.save(com);
    }

//    @GetMapping("/getComment/{id}")
//    public Long getComment(@PathVariable(value = "id") Long id){
//        return commentRepository.findCom(id) ;
//    }

    @GetMapping("/auth/getComments/{id}")
    public List<CommentUser> getComment(@PathVariable(value = "id") Long id)
    {
        List<CommentUser> send = new ArrayList<CommentUser>();
        List<Comment> c = commentRepository.findComment(id);
        for(int i = 0 ; i < c.size() ; i++)
        {
            Long idx = c.get(i).getUser_id();
            CommentUser temp = new CommentUser() ;
            temp.setUser_name(commentRepository.findUserName(idx));
            temp.setUser_photo(commentRepository.findUserPhoto(idx));
            temp.setTimeline_id(c.get(i).getTimeline_id());
            temp.setTime(c.get(i).getTime());
            temp.setComment(c.get(i).getComment());
            temp.setDate(c.get(i).getDate());
            temp.setUser_id(c.get(i).getUser_id());
            temp.setId(c.get(i).getId());
            send.add(temp);
        }
        return send ;
    }

    @GetMapping("/auth/countComment/{id}")
    public Long countComment(@PathVariable(value = "id") Long id){
        return commentRepository.countCom(id) ;
    }

    @PutMapping("/auth/updateComment/{id}")
    public Comment updateCom(@PathVariable(value = "id") Long id, @RequestBody Comment peoplenew){
        Comment peopleold = commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
        peopleold.setComment(peoplenew.getComment());
        peopleold.setDate(peoplenew.getDate());
        peopleold.setTime(peoplenew.getTime());
        return commentRepository.save(peopleold);
    }

    @DeleteMapping("/auth/deleteComment/{id}")
    public boolean deleteuser(@PathVariable(value = "id") Long id) {
        Comment people = commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
        commentRepository.delete(people);
        return true;
    }
}
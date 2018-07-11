package com.example.senyumdifabel.bookmark;

import com.example.senyumdifabel.ResourceNotFoundException;
import com.example.senyumdifabel.params.Params;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class BookmarkController {
    private BookmarkRepository bookmarkRepository;

    @Autowired
    public BookmarkController(BookmarkRepository bookmarkRepository){
        this.bookmarkRepository = bookmarkRepository;
    }

    @PostMapping("/auth/addBookmark")
    public Bookmark addBookmark(@RequestBody Bookmark mark){
        return bookmarkRepository.save(mark);
    }

//    @GetMapping("/auth/getBookmark/{id}")
//    public List<Bookmark> getBook(@PathVariable(value = "id") Long id){
//        return bookmarkRepository.findMark(id) ;
//    }

    @PutMapping("/auth/updateBookmark/{id}")
    public Bookmark updatemark(@PathVariable(value = "id") Long id, @RequestBody Bookmark peoplenew){
        Bookmark peopleold = bookmarkRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
        peopleold.setUser_id(peoplenew.getUser_id());
        peopleold.setJob_id(peoplenew.getJob_id());
        return bookmarkRepository.save(peopleold);
    }

    @PostMapping("/auth/deleteBookmark")
    public boolean deleteuser(@RequestBody Params x) {
        Long x1 = x.getParam1() ;
        Long x2 = x.getParam2() ;
        Bookmark leave = bookmarkRepository.findDelete(x1,x2);
        if(leave == null)
        {
            return false ;
        }
        else
        {
            bookmarkRepository.delete(leave);
            return true ;
        }

    }
}

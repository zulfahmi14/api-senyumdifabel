package com.example.senyumdifabel.contact;

import com.example.senyumdifabel.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactController {
    private ContactRepository contactRepository ;

    @Autowired
    public ContactController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @PostMapping("/addContact")
    public Contact addContact(@RequestBody Contact con){
        return contactRepository.save(con);
    }

    @GetMapping("/getContact/{id}")
    public List<Contact> getCon(@PathVariable(value = "id") Long id){
        return contactRepository.findCon(id) ;
    }

    @PutMapping("/updateContact/{id}")
    public Contact updatecon(@PathVariable(value = "id") Long id, @RequestBody Contact peoplenew){
        Contact peopleold = contactRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
        peopleold.setContact(peoplenew.getContact());
        peopleold.setForm(peoplenew.getForm());
        peopleold.setUser_id(peoplenew.getUser_id());
        return contactRepository.save(peopleold);
    }

    @DeleteMapping("/deleteContact/{id}")
    public boolean deleteuser(@PathVariable(value = "id") Long id) {
        Contact people = contactRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
        contactRepository.delete(people);
        return true;
    }
}

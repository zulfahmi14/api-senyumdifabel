package com.example.senyumdifabel.company;

import com.example.senyumdifabel.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class CompanyController {
    private CompanyRepository companyRepository ;

    @Autowired
    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @PostMapping("/auth/addCompany")
    public Company addCompany(@RequestBody Company edu){
        return companyRepository.save(edu);
    }

    @GetMapping("/auth/getCompanies")
    public List<Company> show(){
        return companyRepository.findAll();
    }

    @PutMapping("/auth/updateCompany/{id}")
    public Company updateCompany(@PathVariable(value = "id") Long id, @RequestBody Company peoplenew){
        Company peopleold = companyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
        peopleold.setUser_name(peoplenew.getUser_name());
        peopleold.setUser_email(peoplenew.getUser_email());
        peopleold.setUser_password(peoplenew.getUser_password());
        peopleold.setUser_address(peoplenew.getUser_address());
        peopleold.setUser_contact(peoplenew.getUser_contact());
        peopleold.setUser_photo(peoplenew.getUser_photo());
        peopleold.setDescription(peoplenew.getDescription());
        return companyRepository.save(peopleold);
    }

    @DeleteMapping("/auth/deleteCompany/{id}")
    public boolean deleteuser(@PathVariable(value = "id") Long id) {
        Company people = companyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id.toString() + " not found"));
        companyRepository.delete(people);
        return true;
    }

}

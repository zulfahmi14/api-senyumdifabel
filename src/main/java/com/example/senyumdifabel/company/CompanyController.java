package com.example.senyumdifabel.company;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {
    private CompanyRepository companyRepository ;

    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }


}

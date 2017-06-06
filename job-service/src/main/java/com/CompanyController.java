package com;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyRepository repository;

    public CompanyController(CompanyRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public Iterable<Company> all() {
        return this.repository.findAll();
    }

    @GetMapping("/{id}")
    public Company getIndividualContact(@PathVariable("id") Long id) {return this.repository.findOne(id);}

    @PostMapping("")
    public Company create(@RequestBody Company company) {
        return this.repository.save(company);
    }

}
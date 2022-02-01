package com.learning.backend.controllers;

import com.learning.backend.models.PersonModel;
import com.learning.backend.services.interfaces.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/persons")
public class PersonsController {
    @Autowired
    IPersonService personService;

    @GetMapping
    public List<PersonModel> getPersons() {
        return personService.getAllPersons();
    }

    @PostMapping
    public Integer addPerson(@RequestBody PersonModel model) {
        return personService.addPerson(model);
    }

    @DeleteMapping
    public Boolean deletePerson(@RequestBody PersonModel model) {
        return personService.deletePerson(model.getId());
    }
}

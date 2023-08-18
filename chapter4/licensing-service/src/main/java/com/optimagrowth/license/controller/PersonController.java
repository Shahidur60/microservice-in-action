package com.optimagrowth.license.controller;

import com.optimagrowth.license.model.Person;
import com.optimagrowth.license.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("/persons")
    public List<Person> getPersons() {
        return personService.getPersons();
    }

    @GetMapping("/{id}")
    public Person UserById(@PathVariable("id") Long id) {
        return personService.personById(id);
    }

    @PutMapping("/{id}")
    public Person updateUser(@PathVariable Long id, @RequestBody Person person) {
        return personService.updatePerson(id, person);
    }

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public Person createUser(@RequestBody Person person) {
        return personService.createPerson(person);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
    }
}



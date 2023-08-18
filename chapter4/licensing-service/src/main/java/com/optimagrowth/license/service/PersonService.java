package com.optimagrowth.license.service;

import com.optimagrowth.license.model.Person;
import com.optimagrowth.license.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public List<Person> getPersons() {
        return this.personRepository.findAll();
    }

    public Person createPerson( Person person){
        return this.personRepository.save(person);
    }

    public Person personById(@PathVariable("id") Long id) {
        Optional<Person> optionalUser = personRepository.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }
        return null;
    }

    public Person updatePerson(Long id, Person person) {
        person.setId(id);
        return personRepository.save(person);
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }
}

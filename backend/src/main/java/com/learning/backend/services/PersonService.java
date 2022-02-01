package com.learning.backend.services;

import com.learning.backend.entities.Person;
import com.learning.backend.models.PersonModel;
import com.learning.backend.repositories.IPersonRepository;
import com.learning.backend.services.interfaces.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService implements IPersonService {
    @Autowired
    IPersonRepository personRepository;


    @Override
    public List<PersonModel> getAllPersons() {
        var persons = new ArrayList<PersonModel>();
        personRepository.findAll().forEach((e)->
                persons.add(new PersonModel(e.getId(), e.getFirstname(), e.getLastname(), e.getAddress())));

        return persons;
    }

    @Override
    public Integer addPerson(PersonModel model) {
        Person person = new Person();
        person.setId(model.getId());
        person.setFirstname(model.getFirstName());
        person.setLastname(model.getLastName());
        person.setAddress(model.getAddress());
        return personRepository.save(person).getId();
    }

    @Override
    public Boolean deletePerson(Integer id) {
        try {
            Person person = new Person();
            person.setId(id);
            personRepository.delete(person);
            return true;
        }catch (Exception ex) {
            return false;
        }
    }

}

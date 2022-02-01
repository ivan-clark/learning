package com.learning.backend.services.interfaces;

import com.learning.backend.models.PersonModel;

import java.util.List;

public interface IPersonService {
    List<PersonModel> getAllPersons();
    Integer addPerson(PersonModel model);
    Boolean deletePerson(Integer id);
}

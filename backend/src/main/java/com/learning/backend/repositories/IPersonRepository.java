package com.learning.backend.repositories;

import com.learning.backend.entities.Person;
import org.springframework.data.repository.CrudRepository;

public interface IPersonRepository extends CrudRepository<Person, Integer> {
}

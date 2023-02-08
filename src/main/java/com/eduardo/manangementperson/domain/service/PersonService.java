package com.eduardo.manangementperson.domain.service;

import com.eduardo.manangementperson.domain.dto.PersonDTO;
import com.eduardo.manangementperson.domain.entity.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {

    Person save(Person person);

    List<Person> listPerson(PersonDTO personDTO);

    Optional<Person> findById(Integer id);

    void deleteById(Integer id);

}

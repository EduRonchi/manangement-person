package com.eduardo.manangementperson.domain.controller;

import com.eduardo.manangementperson.domain.dto.PersonDTO;
import com.eduardo.manangementperson.domain.entity.Person;
import com.eduardo.manangementperson.domain.repository.PersonRepository;
import com.eduardo.manangementperson.domain.service.impl.PersonServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonServiceImpl personServiceImpl;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Person> listPerson(PersonDTO personDTO){
        return personServiceImpl.listPerson(personDTO);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Person> findById(final @PathVariable("id") Integer id) {
        return personServiceImpl.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person save(@RequestBody Person person){
        return personServiceImpl.save(person);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> update(@PathVariable("id") Integer id, @RequestBody Person person) {
        return ResponseEntity.ok(personServiceImpl.updatePerson(id, person));
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Integer id) {
        personRepository.deleteById(id);
    }
}

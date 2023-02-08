package com.eduardo.manangementperson.domain.service.impl;

import com.eduardo.manangementperson.domain.dto.PersonDTO;
import com.eduardo.manangementperson.domain.entity.Person;
import com.eduardo.manangementperson.domain.repository.PersonRepository;
import com.eduardo.manangementperson.domain.service.PersonService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {


    private final PersonRepository personRepository;

    public Person save(Person person){
        return personRepository.save(person);
    }

    @Override
    public Optional<Person> findById(Integer id) {
        return personRepository.findById(id);
    }

    public List<Person> listPerson(PersonDTO personDTO){
        return personRepository.findAll();
    }


    public void deleteById(Integer id){
        personRepository.deleteById(id);
    }

    @Transactional
    public Person updatePerson(Integer id, Person updatedPerson) {
        Person person = personRepository.findById(id).orElseThrow(() -> new RuntimeException("Person not found"));
        if(updatedPerson.getPersonName() != null){
            person.setPersonName(updatedPerson.getPersonName());
        }
        if(updatedPerson.getBornDate() != null){
            person.setBornDate(updatedPerson.getBornDate());
        }
        if(updatedPerson.getAddressPrincipalId() != null){
            person.setAddressPrincipalId(updatedPerson.getAddressPrincipalId());
        }

        return personRepository.save(person);
    }

}

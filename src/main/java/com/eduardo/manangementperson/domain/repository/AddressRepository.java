package com.eduardo.manangementperson.domain.repository;

import com.eduardo.manangementperson.domain.entity.Address;
import com.eduardo.manangementperson.domain.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    List<Address> findByPerson(Optional<Person> person);

}
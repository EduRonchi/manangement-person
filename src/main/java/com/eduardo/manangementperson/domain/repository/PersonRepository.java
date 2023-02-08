package com.eduardo.manangementperson.domain.repository;

import com.eduardo.manangementperson.domain.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    Optional<Person> findById(final Integer personId);

    void deleteById(Integer id);
}
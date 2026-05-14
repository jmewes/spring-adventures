package com.experimental_software.spring_adventures.person;

import com.experimental_software.spring_adventures.person.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

}

package com.experimental_software.spring_adventures.person;

import com.experimental_software.spring_adventures.person.entities.Businessentity;
import com.experimental_software.spring_adventures.person.entities.Person;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "Persons")
public class PersonController {

  private final PersonRepository personRepository;
  private final BusinessentityRepository businessentityRepository;

  @PostMapping("/api/persons")
  public ResponseEntity<Person> createPerson(@RequestBody Person person) {
    Businessentity businessentity = businessentityRepository.save(new Businessentity());
    person.setBusinessentity(businessentity);
    person.setId(businessentity.getId());

    Person savedPerson = personRepository.save(person);
    return ResponseEntity.status(201).body(savedPerson);
  }
}

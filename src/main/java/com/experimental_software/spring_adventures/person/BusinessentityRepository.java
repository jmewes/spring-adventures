package com.experimental_software.spring_adventures.person;

import com.experimental_software.spring_adventures.person.entities.Businessentity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessentityRepository extends JpaRepository<Businessentity, Long> {

}

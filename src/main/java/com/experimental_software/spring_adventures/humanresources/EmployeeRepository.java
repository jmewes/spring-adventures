package com.experimental_software.spring_adventures.humanresources;

import com.experimental_software.spring_adventures.humanresources.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}

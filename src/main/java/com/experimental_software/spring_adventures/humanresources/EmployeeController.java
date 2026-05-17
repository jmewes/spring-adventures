package com.experimental_software.spring_adventures.humanresources;

import com.experimental_software.spring_adventures.humanresources.entities.Employee;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "Employee")
class EmployeeController {

  private final EmployeeRepository employeeRepository;

  @GetMapping("/api/employees")
  public List<Employee> getAllEmployees() {
    return employeeRepository.findAll();
  }

  @GetMapping("/api/employees/{id}")
  public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id) {
    return ResponseEntity.of(employeeRepository.findById(id));
  }

  @PostMapping("/api/employees")
  public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
    Employee savedEmployee = employeeRepository.save(employee);
    return ResponseEntity.status(201).body(savedEmployee);
  }
}

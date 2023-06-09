package com.isomorphs.keycloak.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isomorphs.keycloak.model.Employee;
import com.isomorphs.keycloak.repository.EmployeeRepository;

@RestController
public class EmployeeController {

		@Autowired
		EmployeeRepository employeeRepository;
		
		
		@PostMapping("/admin/employee")
		@RolesAllowed("admin")
		public ResponseEntity<Employee> saveEmployee(Employee employee){
			
			return ResponseEntity.ok(employeeRepository.save(employee));
		}
		
		@GetMapping("/user/employee")
		@RolesAllowed({"employee","admin"})
		public ResponseEntity<List<Employee>> getEmployee(){
			return ResponseEntity.ok(employeeRepository.findAll());
		}
	
	
}

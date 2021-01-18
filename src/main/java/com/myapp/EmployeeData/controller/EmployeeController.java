package com.myapp.EmployeeData.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.EmployeeData.entity.Employee;
import com.myapp.EmployeeData.exception.ResourceNotFoundException;
import com.myapp.EmployeeData.repository.EmployeeReepository;
@CrossOrigin("http://localhost:4200")
@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeReepository repo;
	
	//get all employee
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return repo.findAll();
	}
	
	//create employee rest api
	@PostMapping("/createEmployee")
	public Employee createEmployee(@RequestBody Employee employee) {
		return repo.save(employee);
	}
	//get employee by id rest api
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		Employee orElseThrow = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id " + id));
		return ResponseEntity.ok(orElseThrow);
	}
	//update Employee rest api
	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
		Employee save = repo.save(employee);
		return ResponseEntity.ok(save);
	}
	//delete employee by id
	@DeleteMapping("/deleteEmployee/{id}")
	public void deleteEmployee(@PathVariable Long id){
           repo.deleteById(id);
	}

}

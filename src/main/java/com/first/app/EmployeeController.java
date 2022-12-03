package com.first.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/employees")

public class EmployeeController {
	
	private EmployeeService empser;

	public EmployeeController(EmployeeService empser) {
		super();
		this.empser = empser;
	}
	
	@PostMapping()
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp){
		return new ResponseEntity<Employee>(empser.saveEmployee(emp),HttpStatus.CREATED);
	}
	
	@GetMapping(value="/details")
	public @ResponseBody List<Employee> getAllEmployees(){
		
		
		return empser.getAllEmployees();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
		return new ResponseEntity<Employee>(empser.getEmployeeById(id),HttpStatus.OK);
	}
	
	
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id ,@RequestBody Employee emp)
	{
		return new ResponseEntity<Employee>(empser.updateEmployee(emp, id),HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id){
		empser.deleteEmployee(id);
		return new ResponseEntity<String>("Employee deleted Successfully!!",HttpStatus.OK);	
	}
	

}

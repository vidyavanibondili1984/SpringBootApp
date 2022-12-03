package com.first.app;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	EmployeeRepository emp;

	public EmployeeServiceImpl(EmployeeRepository emp) {
		super();
		this.emp = emp;
	}
	
	@Override
	public Employee saveEmployee(Employee e) {
		
		return emp.save(e);
	}

	@Override
	public List<Employee> getAllEmployees() {
		System.out.println("called");
				return emp.findAll();
	}

	@Override
	public Employee getEmployeeById(Long id) {

		Optional<Employee> employee=emp.findById(id);
		if(employee.isPresent())
		{
			return employee.get();
		}
		else
		{
			throw new ResourceNotFoundException("Employee","id",id);
		}
			
		
	}

	@Override
	public Employee updateEmployee(Employee e, Long id) {
		Employee exist_emp=emp.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee","id",id));
		exist_emp.setFirstname(e.getFirstname());
		exist_emp.setLastname(e.getLastname());
		exist_emp.setEmail(e.getEmail());
		emp.save(exist_emp);
		return exist_emp;
	}

	@Override
	public void deleteEmployee(Long id) {
		emp.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee","id",id));
		emp.deleteById(id);
		
	}
	
	
	
	
}

package com.first.app;

import java.util.List;

public interface EmployeeService {
	
	Employee saveEmployee(Employee e);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(Long id);
	Employee updateEmployee(Employee e,Long id);
	void deleteEmployee(Long id);

}

package dev.mai.services;

import java.util.List;

import dev.mai.models.Employee;

public interface EmployeeService {
	
	public Employee getEmployee(int id);
	public Employee addEmployee(Employee e);
	public List<Employee> getAllEmployees();

}

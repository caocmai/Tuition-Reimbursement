package dev.mai.repositories;

import java.util.List;

import dev.mai.models.Employee;

public interface EmployeeRepo {

	public Employee addEmployee(Employee e);
	public Employee getEmployee(int id);
	public List<Employee> getAllEmployee();
	public Employee updateEmployee(Employee changeE);
	public Employee deleteEmployee(int id);



}

package dev.mai.repositories;

import java.util.List;

import dev.mai.models.Employee;
import dev.mai.models.Request;

public interface EmployeeRepo {

	public Employee addEmployee(Employee e);
	public Employee getEmployee(int id);
	public List<Employee> getAllEmployee();
	public Employee updateEmployee(Employee changeE);
	public Employee deleteEmployee(int id);
	public Employee getEmployByLogin(String username, String password);
	public List<Request> getEmployeeRequests(Employee e);



}

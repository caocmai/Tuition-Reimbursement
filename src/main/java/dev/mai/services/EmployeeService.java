package dev.mai.services;

import java.util.List;

import dev.mai.models.Employee;
import dev.mai.models.Form;
import dev.mai.models.Request;

public interface EmployeeService {
	
	public Employee getEmployee(int id);
	public Employee addEmployee(Employee e);
	public List<Employee> getAllEmployees();
	public Form addForm(Form f);
	
	public Employee getEmloyeeByLogin(String username, String password);
	public List<Request> getAllRequests(Employee e);

}

package dev.mai.services;

import java.util.List;

import dev.mai.models.Employee;
import dev.mai.models.Form;
import dev.mai.models.Request;
import dev.mai.repositories.EmployeeRepo;
import dev.mai.repositories.FormRepo;
import dev.mai.repositories.FormRepoImpl;

public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepo er;
	private FormRepo fr;
	
	public EmployeeServiceImpl(EmployeeRepo er) {
		this.er = er;
		this.fr = new FormRepoImpl();
	}

	@Override
	public Employee getEmployee(int id) {
		return er.getEmployee(id);
	}

	@Override
	public Employee addEmployee(Employee e) {
		return er.addEmployee(e);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return er.getAllEmployee();
	}

	@Override
	public Form addForm(Form f, Employee e) {
		f = fr.addForm(f, e);
		return f;
	}

	@Override
	public Employee getEmloyeeByLogin(String username, String password) {
		return er.getEmployByLogin(username, password);
	}

	@Override
	public List<Request> getAllRequests(Employee e) {
		return er.getEmployeeRequests(e);
	}

}

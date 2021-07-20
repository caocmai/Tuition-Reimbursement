package dev.mai.services;

import dev.mai.models.Employee;
import dev.mai.repositories.EmployeeRepo;

public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepo er;
	
	public EmployeeServiceImpl(EmployeeRepo er) {
		this.er = er;
	}

	@Override
	public Employee getEmployee(int id) {
		return er.getEmployee(id);
	}

}

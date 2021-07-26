package dev.mai.services;

import java.util.List;

import dev.mai.models.Department;
import dev.mai.models.Employee;
import dev.mai.repositories.DepartmentRepo;

public class DepartmentServiceImpl implements DepartmentService {
	
	private DepartmentRepo dr;
		
	public DepartmentServiceImpl(DepartmentRepo dr) {
		this.dr = dr;
	}

	@Override
	public Department getDepartment(int id) {
		return dr.getDepartment(id);
	}

	@Override
	public Department addDepartment(Department d) {
		return dr.addDepartment(d);
	}

	@Override
	public List<Department> getAllDepartments() {
		return dr.getAllDepartment();
	}

	@Override
	public Department getDepartmentByHead(Employee head) {
		return dr.getDepartmentByHead(head);
	}

}

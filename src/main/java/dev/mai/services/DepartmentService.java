package dev.mai.services;

import java.util.List;

import dev.mai.models.Department;
import dev.mai.models.Employee;

public interface DepartmentService {
	public Department getDepartment(int id);
	public Department addDepartment(Department d);
	public List<Department> getAllDepartments();
	public Department getDepartmentByHead(Employee head);
	
	
}

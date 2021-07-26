package dev.mai.repositories;

import java.util.List;

import dev.mai.models.Department;
import dev.mai.models.Employee;

public interface DepartmentRepo {
	
	public Department addDepartment(Department d);
	public Department getDepartment(int id);
	public List<Department> getAllDepartment();
	public Department updateDepartment(Department changeD);
	public Department deleteDepartment(int id);
	public Department getDepartmentByHead(Employee head);

	
}

package dev.mai.services;

import java.util.List;

import dev.mai.models.Employee;
import dev.mai.models.Form;
import dev.mai.models.Request;

public interface EmployeeService {
	
	public Employee getEmployee(int id);
	public Employee addEmployee(Employee e);
	public List<Employee> getAllEmployees();
	public Form addForm(Form f, Employee e);
	
	public Employee getEmloyeeByLogin(String username, String password);
	public List<Request> getAllRequests(Employee e);
	public List<Request> getallPendingRequest(Employee loginEmp);
	public List<Request> getPendingRequestsFromSuper(Employee supervisor);
	public List<Request> getPendingRequestsFromDept(Employee deptHead);
	public List<Request> getPendingRequestsFromDeptSup(Employee loginEmp);
	public Request approveRequest(int requestId, Employee loginEmp);
	
	public List<Request> getPendingAppRequests(Employee loginEmp);
	
	public Request updateRequestGrade(int requestId, String grade);
	public Request approveAbove(int requestId, int amount, String reason);
	public void autoUpdateRequests();

}

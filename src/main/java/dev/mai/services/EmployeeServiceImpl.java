package dev.mai.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dev.mai.models.Department;
import dev.mai.models.Employee;
import dev.mai.models.Form;
import dev.mai.models.Request;
import dev.mai.repositories.DepartmentRepo;
import dev.mai.repositories.DepartmentRepoImpl;
import dev.mai.repositories.EmployeeRepo;
import dev.mai.repositories.FormRepo;
import dev.mai.repositories.FormRepoImpl;
import dev.mai.repositories.RequestRepo;
import dev.mai.repositories.RequestRepoImpl;

public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepo er;
	private FormRepo fr;
	private RequestRepo rr;
	private DepartmentRepo dr;
	
	public EmployeeServiceImpl(EmployeeRepo er) {
		this.er = er;
		this.fr = new FormRepoImpl();
		this.rr = new RequestRepoImpl();
		this.dr = new DepartmentRepoImpl();
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

	@Override
	public List<Request> getallPendingRequest(Employee loginEmp) {
		List<Request> requests = rr.getAllRequest();
		List<Request> pendingRequests = new ArrayList<Request>();
		
		for (Request r : requests) {
			
			if (!r.isBenCoAppveFinal() && r.getEmployee().getId() != loginEmp.getId()) {
				if (loginEmp.getTitle().equalsIgnoreCase("Approver")) {
					System.out.println("approv");
					if (r.isSuperAppve() && r.isDeptAppve() && r.isBenCoAppve() && r.getGrade() != null) {
						pendingRequests.add(r);
					}
				} else if (loginEmp.isBenCo()) {
					if (r.isSuperAppve() && r.isDeptAppve() && !r.isBenCoAppve()) {
						pendingRequests.add(r);
					}
				} else if (loginEmp.getTitle().equalsIgnoreCase("Supervisor")) {
					System.out.println("super");

					if (!r.isSuperAppve() && r.getEmployee().getSupervisorId() == loginEmp.getId()){
						pendingRequests.add(r);
					}
				} else if (loginEmp.getTitle().equalsIgnoreCase("DeptHead")) {
					System.out.println("Dep");

					if ((r.isSuperAppve() && !r.isDeptAppve()) && (r.getEmployee().getDeptId() == loginEmp.getDeptId())){
						pendingRequests.add(r);
					}	
				} else if (loginEmp.getTitle().equalsIgnoreCase("DeptHead/Super")) {

					if (r.getEmployee().getDeptId() == loginEmp.getDeptId() || r.getEmployee().getSupervisorId() == loginEmp.getId()){
						if (!r.isSuperAppve() || !r.isDeptAppve()) {
							pendingRequests.add(r);
						}
					}
				} 
			}
		}
		
		System.out.println(pendingRequests);
		
		return pendingRequests;
	}

	//not using
	@Override
	public List<Request> getPendingRequestsFromSuper(Employee supervisor) {
		List<Request> requests = rr.getAllRequest();
		List<Request> pendingRequests = new ArrayList<Request>();
		
		for (Request r : requests) {
			if (!r.isBenCoAppveFinal() && r.getEmployee().getSupervisorId() == supervisor.getId() && !r.isSuperAppve()) {
				pendingRequests.add(r);
			}
		}
		
		return pendingRequests;
	}

	// not using
	@Override
	public List<Request> getPendingRequestsFromDept(Employee deptHead) {
		Department d = dr.getDepartmentByHead(deptHead);
		
		List<Request> requests = rr.getAllRequest();
		
		List<Request> pendingRequests = new ArrayList<Request>();
		
		for (Request r : requests) {
			System.out.println(r.getEmployee().getDeptId());
			System.out.println(deptHead.getDeptId());

			if (!r.isBenCoAppveFinal() && r.getEmployee().getDeptId() == d.getId()) {
				System.out.println("is it true?");
				pendingRequests.add(r);
			}
		}
		
		return pendingRequests;
	}

	// not using
	@Override
	public List<Request> getPendingRequestsFromDeptSup(Employee loginEmp) {
		List<Request> requests = rr.getAllRequest();
		List<Request> pendingRequests = new ArrayList<Request>();
		
		for (Request r : requests) {
			if (!r.isBenCoAppveFinal() && r.getEmployee().getId() != loginEmp.getId() && !r.isDeptAppve()) {
				if (r.getEmployee().getDeptId() == loginEmp.getDeptId() || r.getEmployee().getSupervisorId() == loginEmp.getDeptId()) {
					pendingRequests.add(r);
				}
			}
		}
		
		return pendingRequests;
	}

	@Override
	public Request approveRequest(int requestId, Employee loginEmp) {
		Request r = rr.getRequest(requestId);
		
		if (loginEmp.getTitle().equalsIgnoreCase("Approver")) {
			r.setBenCoAppveFinal(true);
			Employee e = r.getEmployee();
			e.setTotalReimbursement(e.getTotalReimbursement()+r.getAmountAppve());
			er.updateEmployee(e);
//			approveRequest(r);
		} else if (loginEmp.isBenCo()) {
			r.setBenCoAppve(true);
//			approveAmount(r);
		} else if (loginEmp.getTitle().equalsIgnoreCase("Supervisor")) {
			r.setSuperAppve(true);
		} else if (loginEmp.getTitle().equalsIgnoreCase("DeptHead")) {
			r.setDeptAppve(true);
		} else if (loginEmp.getTitle().equalsIgnoreCase("DeptHead/Super")) {
			r.setSuperAppve(true);
			r.setDeptAppve(true);
		} 
		
		r = rr.updateRequest(r);
		return r;
		
	}
	
	// not using
	private void approveAmount(Request r) {
		String eventType = r.getForm().getEventType();
		Employee e = r.getEmployee();
	
		int eventReimbursement = 0;
		int totalReimbusement = e.getTotalReimbursement();
		
	
		if (eventType.equalsIgnoreCase("UniversityCourses")) {
			eventReimbursement = (int) (r.getForm().getCost() * .80);
		} else if (eventType.equalsIgnoreCase("Seminars")) {
			eventReimbursement = (int) (r.getAmountAppve() * .60);
		} else if (eventType.equalsIgnoreCase("CertificationPreparationClasses")) {
			eventReimbursement = (int) (r.getForm().getCost() * .75);

		} else if (eventType.equalsIgnoreCase("Certification")) {
			eventReimbursement = (int) (r.getForm().getCost() * 1.00);

		} else if (eventType.equalsIgnoreCase("TechnicalTraining")) {
			eventReimbursement = (int) (r.getForm().getCost() * .90);

		} else if (eventType.equalsIgnoreCase("Other")) {
			eventReimbursement = (int) (r.getForm().getCost() * .30);

		}
		
		if (1000 - totalReimbusement - eventReimbursement < 0) {
			eventReimbursement = 1000 - totalReimbusement;
			r.setAmountAppve(0);
//			return eventReimbursement;
//			e.setTotalReimbursement(1000);
		} else {
			r.setAmountAppve(eventReimbursement);
//			e.setTotalReimbursement(totalReimbusement+eventReimbursement); 
//			return eventReimbursement;
		}
		
//		er.updateEmployee(e);
		
//		totalReimbusement = 1000 - eventReimbursement - r.getEmployee().getTotalReimbursement();
//		if (totalReimbusement > 0) { 
//			
//			r.getEmployee().setTotalReimbursement(totalReimbusement); 
//			
//		}
		
//		System.out.println(eventReimbursement + "  " + totalReimbusement );
		
//		rr.updateRequest(r);
		
	}
	
	// not using
	private void approveRequest(Request r) {
		Employee e = r.getEmployee();
//		if (e.getTotalReimbursement() + r.getAmountAppve() > 1000) {
//			e.setTotalReimbursement(1000);
//		} else {
			e.setTotalReimbursement(e.getTotalReimbursement()+r.getAmountAppve());
//		}
//		
		er.updateEmployee(e);
	}

	@Override
	public List<Request> getPendingAppRequests(Employee loginEmp) {
		List<Request> requests =  rr.getPendingRequests(loginEmp);
		List<Request> gradesRequests = new ArrayList<Request>();
		
		for (Request r : requests) {
			if (r.isSuperAppve() && r.isDeptAppve() && r.isBenCoAppve() && r.getGrade() == null) {
				gradesRequests.add(r);
			}
		}
		return gradesRequests;
		
//		return er.getPendingAppRequests(loginEmp);
	} 

	@Override
	public Request updateRequestGrade(int requestId, String grade) {
		
		Request r = rr.getRequest(requestId);
		r.setGrade(grade);
		r = rr.updateRequest(r);
		return r;
	}

	@Override
	public Request approveAbove(int requestId, int amount, String reason) {
		Request r = rr.getRequest(requestId);
		r.setAmountAboveReason(reason);
		r.setAmountAppve(amount);
		r = rr.updateRequest(r);
		return r;
	}

	@Override
	public void autoUpdateRequests() {
		List<Request> requests = rr.getAllRequest();
		Date d = new Date();
		long day = 86_400_000L;
		
		for (Request r : requests) {
			if (r.getStartRequest() -  d.getTime() == (day * 3)) {
				r.setSuperAppve(true);
			} else if (r.getStartRequest() -  d.getTime() == (day * 5)) {
				r.setDeptAppve(true);
			}
		}
	}

}

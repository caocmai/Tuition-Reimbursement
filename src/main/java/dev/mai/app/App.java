package dev.mai.app;

import java.util.Timer;
import java.util.TimerTask;

import org.eclipse.jetty.util.log.Log;

//import org.apache.log4j.Logger;

import dev.mai.controllers.DepartmentController;
import dev.mai.controllers.EmployeeController;
import dev.mai.repositories.DepartmentRepo;
import dev.mai.repositories.DepartmentRepoImpl;
import dev.mai.repositories.EmployeeRepo;
import dev.mai.repositories.EmployeeRepoImpl;
import dev.mai.services.DepartmentService;
import dev.mai.services.DepartmentServiceImpl;
import dev.mai.services.EmployeeService;
import dev.mai.services.EmployeeServiceImpl;
import io.javalin.Javalin;

public class App {
	
//	final static Logger log = Logger.getLogger(App.class);

	
	public static void main(String[] args) {
		// Javalin object
		// create method takes in a lambda config to enable CORS to work
		Javalin app = Javalin.create(config -> config.enableCorsForAllOrigins());
		establishRoutes(app);
		
		// Run Javalin
		app.start(); // Default port is 7000, if don't specified

	}
	
	private static void establishRoutes(Javalin app) {
		
		EmployeeRepo er = new EmployeeRepoImpl();
		EmployeeService es = new EmployeeServiceImpl(er);
		EmployeeController ec = new EmployeeController(es);
		
		DepartmentRepo dr = new DepartmentRepoImpl();
		DepartmentService ds = new DepartmentServiceImpl(dr);
		DepartmentController dc = new DepartmentController(ds);
		
//		List<Department> depts = dr.getAllDepartment();
//		
//		for (Department d:depts) {
//			System.out.println(d.getHead());
//		}
//		Employee e = er.getEmployee(64);
//		System.out.println(dr.getDepartmentByHead(e));
//		
		
//		Employee e = new Employee("Joe");
//		er.addEmployee(new Employee("First"));
//		er.getAllEmployee();
		
//		Date date = new Date();
//		long reset = date.getTime() + (86_400_000L * 160);
//		
//		Employee emp1 = new Employee("DeptHead", "dh", "pass", "Martina", "Candreva", 0, reset, false);
//		Employee emp2 = new Employee("DeptHead/Super", "dh3", "pass", "James", "Swan", 0, reset, false);
//		Employee emp3 = new Employee("Supervisor", "sup", "pass", "John", "Simon", 0, reset, false);
//		Employee emp4 = new Employee("Supervisor", "sup2", "pass", "Mike", "Quinn", 0, reset, false);
//		
//		Employee emp5 = new Employee("BenCo", "benco", "pass", "Nancy", "Young", 0, reset, true);
//		Employee emp6 = new Employee("BenCo", "benco2", "pass", "Keith", "Koch", 200, reset, true);
//		
//		
//		Employee emp7 = new Employee("Associate", "user", "pass", "Jack", "Hrabal", 500, reset, false);
//		Employee emp8 = new Employee("Associate", "user1", "pass", "Sandra", "Rajkovic", 100, reset, false);
//		Employee emp9 = new Employee("Associate", "user2", "pass", "Pat", "Ross", 0, reset, false);
//		
//		Employee emp13 = new Employee("Associate", "user3", "pass", "David", "Jones", 750, reset, false);
//		Employee emp14 = new Employee("Associate", "user4", "pass", "Roy", "Giv", 0, reset, false);
//		
//		Employee emp10 = new Employee("Associate", "user5", "pass", "Kim", "Lee", 200, reset, false);
//		Employee emp11 = new Employee("Approver", "approver", "pass", "Amy", "Long", 0, reset, true);
//		Employee emp12 = new Employee("BenCoSuper", "bencosup", "pass", "Todd", "Max", 100, reset, false);

//		Employee e = er.getEmployee(3);
//		e.setDeptId(1);
//		
//		Employee e2 = er.getEmployee(4);
//		e2.setDeptId(1);
//		Employee e3 = er.getEmployee(5);
//		e3.setDeptId(1);
//		Employee e4 = er.getEmployee(6);
//		e4.setDeptId(1);
//		Employee e5 = er.getEmployee(7);
//		e5.setDeptId(1);
//		Employee e6 = er.getEmployee(8);
//		e6.setDeptId(1);
//		Employee e7 = er.getEmployee(9);
//		e7.setDeptId(2);
//		Employee e8 = er.getEmployee(10);
//		e8.setDeptId(2);
//		Employee e9 = er.getEmployee(11);
//		e9.setDeptId(2);
//		Employee e10 = er.getEmployee(12);
//		e10.setDeptId(2);
//		Employee e11 = er.getEmployee(13);
//		e11.setDeptId(2);
//		Employee e12 = er.getEmployee(14);
//		e12.setDeptId(2);
		
//		er.updateEmployee(e);
//		er.updateEmployee(e2);
//		er.updateEmployee(e3);
//		er.updateEmployee(e4);
//		er.updateEmployee(e5);
//		er.updateEmployee(e6);
//		er.updateEmployee(e7);
//		er.updateEmployee(e8);
//		er.updateEmployee(e9);
//		er.updateEmployee(e10);
//		er.updateEmployee(e11);
//		er.updateEmployee(e12);
//	
//		
//		Employee e = er.getEmployee(18);
//		e.setSupervisorId(17);
//		er.updateEmployee(e);
		
//		Employee e2 = er.getEmployee(4);
//		e2.setSupervisorId(17);
//		er.updateEmployee(e2);
		
//		Department d = new Department("Marketing", 1);
//		Department d2 = new Department("Technology", 2);
//		
//		dr.addDepartment(d);
//		dr.addDepartment(d2);
		
//		er.getEmployee(1);
//		er.deleteEmployee(14);
		
//		Employee ep = er.getEmployee(11);
//		ep.setDeptId(1);
//		er.updateEmployee(ep);
		
//		Employee supere = er.getEmployee(5);
//		
//		RequestRepoImpl rr = new RequestRepoImpl();
////	
//		Request r = rr.getRequest(28);
//		r.setBenCoAppveFinal(false);
//		r.setAmountAppve(240);
//		r.setBenCoAppve(false);
//		rr.updateRequest(r);
////		
//		System.out.println(r);
//		System.out.println(r.getAmountAppve());

		
//		System.out.println(r.getMoreInfoRequests());
//		
//		MoreInfoRequest mr = new MoreInfoRequest(supere, ep, "another more info", false);
//		MoreInfoRequestImpl mrp  = new MoreInfoRequestImpl();
		
//		MoreInfoRequest mpo = mrp.addMoreInfoRequest(mr);
		
//		r.getMoreInfoRequests().add(mpo);
		
//		rr.updateRequest(r);
		
//		mrp.deleteMoreInfoRequest(17);
		
//		new Timer().scheduleAtFixedRate(new TimerTask(){
//		    @Override
//		    public void run(){
//		    	ec.autoUpdateRequests();
//		    }
//		},0,3600000);
		
		app.post("/employees/login", ec.employeeLogin);
		app.post("/employees/requests/form", ec.addForm);
		app.get("/employees/requests", ec.getRequests);
		
		app.get("/employees/requests/pending", ec.getPendingRequests);
		app.post("/employees/requests/pending/approve", ec.updatePendingRequest);
		app.get("/employees/requests/pending/grade", ec.getPendingAppRequests);
		
		// get requests to add grades
		app.post("/employees/requests/pending/grade", ec.updateRequestGrade);

		
		app.get("/employees/:id", ec.getEmployeeById);
		app.post("/employees", ec.addEmployee);
		app.get("/employees", ec.getAllEmployees);
		app.get("/departments/:id", dc.getDepartmentById);
		app.post("/departments", dc.addDepartment);
		app.get("/departments", dc.getAllDepartments);
		
	}

}

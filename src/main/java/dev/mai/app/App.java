package dev.mai.app;

import java.util.List;

//import org.apache.log4j.Logger;

import dev.mai.controllers.DepartmentController;
import dev.mai.controllers.EmployeeController;
import dev.mai.models.Employee;
import dev.mai.models.Form;
import dev.mai.models.Request;
import dev.mai.repositories.DepartmentRepo;
import dev.mai.repositories.DepartmentRepoImpl;
import dev.mai.repositories.EmployeeRepo;
import dev.mai.repositories.EmployeeRepoImpl;
import dev.mai.repositories.FormRepoImpl;
import dev.mai.repositories.RequestRepoImpl;
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
		
//		Employee e = new Employee("Joe");
//		er.addEmployee(new Employee("First"));
//		er.getAllEmployee();
		
//		public Employee(String title, String username, String password, String firstName, String lastName,
//				int totalReimbursement, long resetDate, boolean isBenCo, Department dept) {
//			super();
//			this.title = title;
//			this.username = username;
//			this.password = password;
//			this.firstName = firstName;
//			this.lastName = lastName;
//			this.totalReimbursement = totalReimbursement;
//			this.resetDate = resetDate;
//			this.isBenCo = isBenCo;
//			this.dept = dept;
//		}
		er.addEmployee(new Employee("Hi"));
		
		
		app.post("/employees/requests/form", ec.addForm);
		app.get("employees/requests", ec.getRequests);
		app.post("/employees/login", ec.employeeLogin);
		app.get("/employees/:id", ec.getEmployeeById);
		
		app.post("/employees", ec.addEmployee);
		
		app.get("/employees", ec.getAllEmployees);
		
		app.get("/departments/:id", dc.getDepartmentById);
		app.post("/departments", dc.addDepartment);
		app.get("/departments", dc.getAllDepartments);
		
//		Employee e1 = es.getEmloyeeByLogin("user", "pass");
//		System.out.println(e1.getLastName());
		
		Employee ee = es.getEmployee(3);
		System.out.println(ee.getTitle());
		System.out.println(ee.getRequests());
		
//		List<Request> rq = ee.getRequests();
		
//		System.out.println(rq);
//		
//		for (Request m : rq) {
//			System.out.println(m);
//		}
////		
//		for (Request re: reqs) {
//			System.out.println(re.toString());
//		}
	}

}

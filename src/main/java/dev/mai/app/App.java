package dev.mai.app;

import org.hibernate.boot.jaxb.hbm.spi.Adapter4;

//import org.apache.log4j.Logger;

import dev.mai.controllers.DepartmentController;
import dev.mai.controllers.EmployeeController;
import dev.mai.models.Request;
import dev.mai.repositories.DepartmentRepo;
import dev.mai.repositories.DepartmentRepoImpl;
import dev.mai.repositories.EmployeeRepo;
import dev.mai.repositories.EmployeeRepoImpl;
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
		
//		new Timer().scheduleAtFixedRate(new TimerTask(){
//		    @Override
//		    public void run(){
//		    	ec.autoUpdateRequests();
//		    }
//		},0,3600000);
		
		app.post("/employees/login", ec.employeeLogin);
		app.post("/employees/requests/form", ec.addForm);
		app.get("/employees/requests/pending", ec.getPendingRequests);
//
		app.get("/employees/requests", ec.getRequests);
		app.get("/employees/requests/:id", ec.getRequestById);

		app.post("/employees/requests/moreinfo", ec.addMoreInfo);
//		
		app.post("/employees/requests/pending/approve", ec.updatePendingRequest);
		app.get("/employees/requests/pending/grade", ec.getPendingAppRequests);
//		
		// get requests to add grades
		app.post("/employees/requests/pending/grade", ec.updateRequestGrade);

		
//		app.get("/employees/:id", ec.getEmployeeById);
//		app.post("/employees", ec.addEmployee);
//		app.get("/employees", ec.getAllEmployees);
//		app.get("/departments/:id", dc.getDepartmentById);
//		app.post("/departments", dc.addDepartment);
//		app.get("/departments", dc.getAllDepartments);
		
	}

}

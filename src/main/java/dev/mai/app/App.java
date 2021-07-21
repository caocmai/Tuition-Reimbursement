package dev.mai.app;

import org.apache.log4j.Logger;

import dev.mai.controllers.EmployeeController;
import dev.mai.repositories.EmployeeRepo;
import dev.mai.repositories.EmployeeRepoImpl;
import dev.mai.services.EmployeeService;
import dev.mai.services.EmployeeServiceImpl;
import io.javalin.Javalin;

public class App {
	
	final static Logger log = Logger.getLogger(App.class);

	
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
	
		app.get("/employees/:id", ec.getEmployeeById);
		app.post("/employees", ec.addEmployee);
		app.get("/employees", ec.getAllEmployees);
	}

}

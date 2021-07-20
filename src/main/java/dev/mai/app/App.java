package dev.mai.app;

import org.apache.log4j.Logger;

import dev.mai.repositories.EmployeeRepo;
import dev.mai.repositories.EmployeeRepoImpl;
import io.javalin.Javalin;

public class App {
	
	final static Logger log = Logger.getLogger(App.class);

	
	public static void main(String[] args) {
		// Javalin object
				// create method takes in a lambda config to enable CORS to work
				Javalin app = Javalin.create(config -> config.enableCorsForAllOrigins());
				
				// Establish Routes/Endpoints
				establishRoutes(app);
				
				// Run Javalin
				app.start(); // Default port is 7000, if don't specified

	}
	
	private static void establishRoutes(Javalin app) {
		
		EmployeeRepo er = new EmployeeRepoImpl();
		
		
//		app.get("/employee", er.getEmployee(1));
	}

}

package dev.mai.controllers;

import java.util.List;

import com.google.gson.Gson;

import dev.mai.models.Employee;
import dev.mai.services.EmployeeService;
import io.javalin.http.Handler;


public class EmployeeController {
	Gson gson = new Gson();
	
	private EmployeeService es;

	
	public EmployeeController(EmployeeService es) {
		this.es = es;
	}
	
	public Handler getEmployeeById = (ctx) -> {
		String input = ctx.pathParam("id");
		int id = checkInt(input);
		
		Employee e = es.getEmployee(id);
		
		if (e != null) {
			ctx.result(gson.toJson(e));
		} else {
			ctx.status(400);
		}
	};
	
	public Handler addEmployee = (ctx) -> {
		Employee e = gson.fromJson(ctx.body(), Employee.class);
		e = es.addEmployee(e);
		
		ctx.result((e != null) ? gson.toJson(e) : "{}");

	};
	
	public Handler getAllEmployees = (ctx) -> {
		List<Employee> employees = es.getAllEmployees();
		
		if (employees != null) {
			ctx.result(gson.toJson(employees));
		} else {
			ctx.status(400);
		}
	};
	
	private int checkInt(String input) {
		if (input.matches("^-?[0-9]+")) {
			return Integer.parseInt(input);
		} else {
			return -1;
		}
		
	}
	
	

}

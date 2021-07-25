package dev.mai.controllers;

import java.util.List;

import com.google.gson.Gson;

import dev.mai.models.Employee;
import dev.mai.models.Form;
import dev.mai.models.Login;
import dev.mai.models.Request;
import dev.mai.services.EmployeeService;
import io.javalin.http.Context;
import io.javalin.http.Handler;


public class EmployeeController {
	Gson gson = new Gson();
	
	private EmployeeService es;
	private Employee loginEmp;

	
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

	public Handler addForm = (ctx) -> {
		Form f = gson.fromJson(ctx.body(), Form.class);
		es.addForm(f, this.loginEmp);
		
		
		
//		Request r = new Request(this.loginEmp,  );
		
//		if (employees != null) {
//			ctx.result(gson.toJson(employees));
//		} else {
//			ctx.status(400);
//		}
		
		returnedContext(ctx, f);
	};

	public Handler employeeLogin = (ctx) -> {
		Login login = gson.fromJson(ctx.body(), Login.class);
		System.out.println("*****LOGIN" + login);
		
		Employee e = es.getEmloyeeByLogin(login.getUsername(), login.getPassword());
		System.out.println(e);
		
		this.loginEmp = e;
		
		
		returnedContext(ctx, e);
		
	};

	public Handler getRequests = (ctx) -> {
		Employee e = gson.fromJson(ctx.body(), Employee.class);
		List<Request> request = es.getAllRequests(e);
		
		returnedContext(ctx, request);
		
	};
	
	
	private int checkInt(String input) {
		if (input.matches("^-?[0-9]+")) {
			return Integer.parseInt(input);
		} else {
			return -1;
		}
		
	}

	private void returnedContext(Context ctx, Object o) {
		if (o != null) {
			ctx.result(gson.toJson(o));
		} else {
			ctx.result("{}");
			ctx.status(400);
		}
	}
	
	
	
	

}

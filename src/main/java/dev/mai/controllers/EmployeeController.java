package dev.mai.controllers;

import java.util.List;

import com.google.gson.Gson;

import dev.mai.models.Employee;
import dev.mai.models.Form;
import dev.mai.models.GetJsonId;
import dev.mai.models.GradeRequest;
import dev.mai.models.JsonMoreInfo;
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
		returnedContext(ctx, f);
	};

	public Handler employeeLogin = (ctx) -> {
		Login login = gson.fromJson(ctx.body(), Login.class);

		Employee e = es.getEmloyeeByLogin(login.getUsername(), login.getPassword());
		System.out.println(e);
		this.loginEmp = e;
		System.out.println("deptmartmetn head" + this.loginEmp.getDeptId());

		returnedContext(ctx, e);
		
	};

	public Handler getRequests = (ctx) -> {
//		Employee e = gson.fromJson(ctx.body(), Employee.class);
		List<Request> requests = es.getAllRequests(this.loginEmp);
	
		returnedContext(ctx, requests);
		

		
	};
	
	public Handler getPendingRequests = (ctx) -> {

		List<Request> requests = es.getallPendingRequest(loginEmp);
		
		returnedContext(ctx, requests);
		
	};

	
	public Handler updatePendingRequest = (ctx) -> {
		GetJsonId jsonObject = gson.fromJson(ctx.body(), GetJsonId.class);

		int requestId = checkInt(jsonObject.getId());
		
		if (jsonObject.getReason() != null && !jsonObject.getReason().equalsIgnoreCase("reason for increase")) {
			int amount = checkInt(jsonObject.getAmount());
			es.approveAbove(requestId, amount, jsonObject.getReason());

		} else {
			es.approveRequest(requestId, this.loginEmp);
		}
		
		
	};

	public Handler getPendingAppRequests = (ctx) -> {
		List<Request> requests = es.getPendingAppRequests(this.loginEmp);
		
		returnedContext(ctx, requests);

	};

	public Handler updateRequestGrade = (ctx) -> {
		GradeRequest gr = gson.fromJson(ctx.body(), GradeRequest.class);

		int requestId = checkInt(gr.getId());
		
		es.updateRequestGrade(requestId, gr.getGrade());
	};

	public Handler getRequestById = (ctx) -> {
		String clientId = ctx.pathParam("id");
		int id = checkInt(clientId);
		Request r = es.getARequest(id);
		returnedContext(ctx, r);
		
	};

	public Handler addMoreInfo = (ctx) -> {
		JsonMoreInfo mi = gson.fromJson(ctx.body(), JsonMoreInfo.class);
		
		int requestId = checkInt(mi.getRequestId());
		int fromId =  checkInt(mi.getFromId());
		int toId = checkInt(mi.getToId());
		String reason =  mi.getReason();
				
		Request r = es.addMoreInfo(requestId, fromId, toId, reason);
		returnedContext(ctx, r);
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

	public void autoUpdateRequests() {
		es.autoUpdateRequests();
		
	}
	
	
	
	

}

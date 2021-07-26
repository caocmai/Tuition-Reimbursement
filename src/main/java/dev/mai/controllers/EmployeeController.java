package dev.mai.controllers;

import java.util.List;

import com.google.gson.Gson;

import dev.mai.models.Employee;
import dev.mai.models.Form;
import dev.mai.models.GetJsonId;
import dev.mai.models.GradeRequest;
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
//		System.out.println("*****LOGIN" + login);

		Employee e = es.getEmloyeeByLogin(login.getUsername(), login.getPassword());
		System.out.println(e);
		this.loginEmp = e;
		System.out.println("deptmartmetn head" + this.loginEmp.getDeptId());

		returnedContext(ctx, e);
		
	};

	public Handler getRequests = (ctx) -> {
//		Employee e = gson.fromJson(ctx.body(), Employee.class);
		List<Request> requests = es.getAllRequests(this.loginEmp);
		
//		System.out.println(requests);
		returnedContext(ctx, requests);
		
//		for (Request r : requests) {
//			System.out.println(r);
//			System.out.println(r.getMoreInfoRequests());
//		}
//		
		
	};
	
//	Supervisor
//	BenCo
//	DeptHead

	public Handler getPendingRequests = (ctx) -> {
//		System.out.println("deptmartmetn head" + loginEmp.getDeptId());

		List<Request> requests = es.getallPendingRequest(loginEmp);
		
		returnedContext(ctx, requests);
//		if (loginEmp.getTitle().equalsIgnoreCase("Approver")) {
//			System.out.println("aproving requests, with grades");
//			
//		} else if (loginEmp.isBenCo()) {
//			requests = es.getallPendingRequest(loginEmp);
//			returnedContext(ctx, requests);
//			
//		} else if (loginEmp.getTitle().equalsIgnoreCase("Supervisor")) {
////			List<Request> requests = es.getPendingRequestsFromSuper(this.loginEmp);
//			System.out.println("super?");
////			returnedContext(ctx, requests);
//		} else if (loginEmp.getTitle().equalsIgnoreCase("DeptHead")) {
////			System.out.println("deptmartmetn head" + loginEmp.getDept());
//			
//			List<Request> requests = es.getPendingRequestsFromDept(this.loginEmp);
//			returnedContext(ctx, requests);
//
//		} else if (loginEmp.getTitle().equalsIgnoreCase("DeptHead/Super")) {
////			System.out.println("deptmartmetn head" + loginEmp.getDept());
//			
//			List<Request> requests = es.getPendingRequestsFromDeptSup(this.loginEmp);
//			returnedContext(ctx, requests);
//
//		} else {
//			ctx.result("{}");
//		}
		
	};

	
	public Handler updatePendingRequest = (ctx) -> {
		GetJsonId jsonObject = gson.fromJson(ctx.body(), GetJsonId.class);
//		
//		System.out.println(jsonObject);
//		System.out.println(jsonObject.getAmount());
//		System.out.println(jsonObject.getReason());

		
		int requestId = checkInt(jsonObject.getId());
		
		if (!jsonObject.getReason().equalsIgnoreCase("reason for increase")) {
			int amount = checkInt(jsonObject.getAmount());
			es.approveAbove(requestId, amount, jsonObject.getReason());

		} else {
			es.approveRequest(requestId, this.loginEmp);
		}
		
		
		
//		if (loginEmp.getTitle().equalsIgnoreCase("Approver")) {
//			System.out.println("aproving requests, with grades");
//		} else if (loginEmp.isBenCo()) {
//			List<Request> requests = es.getallPendingRequest();
//			System.out.println("benco?");
//
//			returnedContext(ctx, requests);
//			
//		} else if (loginEmp.getTitle().equalsIgnoreCase("Supervisor")) {
//			System.out.println("super?");
//		} else if (loginEmp.getTitle().equalsIgnoreCase("DeptHead")) {
//			List<Request> requests = es.getPendingRequestsFromDept(this.loginEmp);
//			returnedContext(ctx, requests);
//
//		} else if (loginEmp.getTitle().equalsIgnoreCase("DeptHead/Super")) {
//			List<Request> requests = es.approveRequestDeptHeadSuper(this.loginEmp);
//			returnedContext(ctx, requests);
//		} else {
//			ctx.result("{}");
//		}
		
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

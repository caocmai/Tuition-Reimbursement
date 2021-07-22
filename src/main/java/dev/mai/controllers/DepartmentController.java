package dev.mai.controllers;

import java.util.List;

import com.google.gson.Gson;

import dev.mai.models.Department;
import dev.mai.services.DepartmentService;
import io.javalin.http.Handler;

public class DepartmentController {
	Gson gson = new Gson();
	
	private DepartmentService ds;

	
	public DepartmentController(DepartmentService ds) {
		this.ds = ds;
	}
	
	public Handler getDepartmentById = (ctx) -> {
		String input = ctx.pathParam("id");
		int id = checkInt(input);
		
		Department d = ds.getDepartment(id);
		
		if (d != null) {
			ctx.result(gson.toJson(d));
		} else {
			ctx.status(400);
		}
	};
	
	public Handler addDepartment = (ctx) -> {
		Department d = gson.fromJson(ctx.body(), Department.class);
		d = ds.addDepartment(d);
		
		ctx.result((d != null) ? gson.toJson(d) : "{}");

	};
	
	public Handler getAllDepartments = (ctx) -> {
		List<Department> Departments = ds.getAllDepartments();
		
		if (Departments != null) {
			ctx.result(gson.toJson(Departments));
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

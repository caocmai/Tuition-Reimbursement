package dev.mai.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import dev.mai.models.Employee;
import dev.mai.models.Form;
import dev.mai.models.Request;
import dev.mai.repositories.EmployeeRepoImpl;
import dev.mai.repositories.FormRepoImpl;
import dev.mai.repositories.RequestRepoImpl;

public class RequestRepoImplTest {
	
	static RequestRepoImpl rr;
	static FormRepoImpl fr;
	static EmployeeRepoImpl er;

	
	@BeforeClass
	public static void setUp() {
		rr = new RequestRepoImpl();
		fr = new FormRepoImpl();
		er = new EmployeeRepoImpl();
		
		
	}
	
	@Test
	public void canAddRequest() {
		Employee e = er.getEmployee(13);

		Form f = new Form("Dallas", "Learn React", 240, "Grade", "Class", "None", 1235);
		fr.addForm(f, e);
		Request r = new Request(1234, false, f);
		rr.addRequest(r);
		assertNotNull(rr.getAllRequest());
	}

	@Test
	public void canGetRequest() {
		Employee e = er.getEmployee(13);

		Form f = new Form("Chicago", "Learn React", 240, "Grade", "Class", "None", 1235);
		fr.addForm(f,e);
		
		Request r = new Request(2344, false, f);
		r = rr.addRequest(r);
		
		assertEquals("Chicago", rr.getRequest(r.getId()).getForm().getLocation());
	}

	@Test 
	public void canUpdateRequest() {
		Employee e = er.getEmployee(13);
		
		Form f = new Form("Austin", "Learn React", 240, "Presentation", "Class", "None", 1235);
		fr.addForm(f,e);
		
		Request r = new Request(2344, false, f);
		r = rr.addRequest(r);
		
		r.setDeptAppve(true);
		r = rr.updateRequest(r);
		
		assertEquals(true, rr.getRequest(r.getId()).isDeptAppve());
	}
	
	@Test
	public void canDeleteRequest() {
		Employee e = er.getEmployee(13);
		e = er.addEmployee(e);

		Form f = new Form("Jackson", "Learn React", 240, "Grade", "Class", "None", 1235);
		fr.addForm(f,e);
	
		Request r = new Request(6787, false, f);
		r.setEmployee(e);
		r = rr.addRequest(r);
		
		int originalSize = rr.getAllRequest().size();
		rr.deleteRequest(r.getId());
		assertNotEquals(originalSize, rr.getAllRequest().size());

	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Tearing down test cases. Runs once");
		rr = null;
	}
}

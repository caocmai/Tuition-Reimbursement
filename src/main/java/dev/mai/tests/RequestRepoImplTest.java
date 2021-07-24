package dev.mai.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import dev.mai.models.Form;
import dev.mai.models.Request;
import dev.mai.repositories.FormRepoImpl;
import dev.mai.repositories.RequestRepoImpl;

public class RequestRepoImplTest {
	
	static RequestRepoImpl rr;
	static FormRepoImpl fr;

	
	@BeforeClass
	public static void setUp() {
		rr = new RequestRepoImpl();
		fr = new FormRepoImpl();
		
	}
	
	@Test
	public void canAddRequest() {
		Form f = new Form("Dallas", "Learn React", 240, "Grade", "Class", "None", 1235);
		fr.addForm(f);
		Request r = new Request(1234, false, f);
		rr.addRequest(r);
		assertNotNull(rr.getAllRequest());
	}

	@Test
	public void canGetRequest() {
		Form f = new Form("Chicago", "Learn React", 240, "Grade", "Class", "None", 1235);
		fr.addForm(f);
		Request r = new Request(2344, false, f);
		rr.addRequest(r);
		
		Form f2 = new Form("Austin", "Learn React", 240, "Presentation", "Class", "None", 1235);
		fr.addForm(f2);
		Request r2 = new Request(2344, false, f);
		rr.addRequest(r2);
		
		assertEquals(4, rr.getRequest(4).getId());
	}

	@Test 
	public void canUpdateRequest() {
		Form f = new Form("Chicago", "Learn React", 240, "Grade", "Class", "None", 1235);
		fr.addForm(f);
		Request r = new Request(2344, false, f);
		rr.addRequest(r);
		
		Form f2 = new Form("Austin", "Learn React", 240, "Presentation", "Class", "None", 1235);
		fr.addForm(f2);
		Request r2 = new Request(2344, false, f);
		rr.addRequest(r2);
		
		r = rr.getRequest(4);
		r.setDeptAppve(true);
		rr.updateRequest(r);
		assertEquals(true, rr.getRequest(4).isDeptAppve());
	}
	
	@Test
	public void canDeleteRequest() {
		Form f = new Form("Jackson", "Learn React", 240, "Grade", "Class", "None", 1235);
		fr.addForm(f);
		Request r = new Request(6787, false, f);
		rr.addRequest(r);
		
		int originalSize = rr.getAllRequest().size();
		rr.deleteRequest(2);
		assertNotEquals(originalSize, rr.getAllRequest().size());

	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Tearing down test cases. Runs once");
		rr = null;
	}
}

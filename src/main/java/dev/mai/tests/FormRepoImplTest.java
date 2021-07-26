package dev.mai.tests;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import dev.mai.models.Employee;
import dev.mai.models.Form;
import dev.mai.repositories.EmployeeRepoImpl;
import dev.mai.repositories.FormRepoImpl;

public class FormRepoImplTest {
	
	static FormRepoImpl fr;
	static EmployeeRepoImpl er;
	 
	
	@BeforeClass
	public static void setUp() {
		fr = new FormRepoImpl();
		er = new EmployeeRepoImpl();
	}
	
	@Test
	public void canAddForm() {
		Employee e = er.getEmployee(13);
		Form f = new Form("Dallas", "Learn React", 240, "Grade", "Class", "None", 1235);
		fr.addForm(f, e);
		assertNotNull(fr.getForm(1));
	}

	@Test
	public void canGetForm() {
		Employee e = er.getEmployee(13);
		Form f = new Form("Dallas", "Learn React", 240, "Grade", "Class", "None", 1235);
		fr.addForm(f, e);
		assertNotNull(fr.getForm(1));
		assertEquals("Dallas", fr.getForm(1).getLocation());
	}

	@AfterClass
	public static void tearDownAftfrClass() throws Exception {
		System.out.println("Tearing down test cases. Runs once");
		fr = null;
	}

}

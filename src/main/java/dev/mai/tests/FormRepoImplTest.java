package dev.mai.tests;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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
		f = fr.addForm(f, e);
		assertNotNull(fr.getForm(f.getId()));
	}

	@Test
	public void canGetForm() {
		Employee e = er.getEmployee(13);
		Form f = new Form("Dallas", "Learn React", 240, "Grade", "Class", "None", 1235);
		f = fr.addForm(f, e);
		assertNotNull(fr.getForm(f.getId()));
		assertEquals("Dallas", fr.getForm(f.getId()).getLocation());
	}
	
	@Test
	public void canUpdateForm() {
		Employee e = er.getEmployee(13);
		Form f = new Form("Dallas", "Learn React", 240, "Grade", "Class", "None", 1235);
		f = fr.addForm(f, e);
		f.setLocation("Austin");
		fr.updateForm(f);
		assertEquals("Austin", fr.getForm(f.getId()).getLocation());
	}
	
	@AfterClass
	public static void tearDownAftfrClass() throws Exception {
		System.out.println("Tearing down test cases.");
		fr = null;
	}

}

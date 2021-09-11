package dev.mai.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import dev.mai.models.Employee;
import dev.mai.repositories.EmployeeRepoImpl;

public class EmployeeRepoImplTest {
	
	static EmployeeRepoImpl er;
	
	@BeforeClass
	public static void setUp() {
		er = new EmployeeRepoImpl();
	}
	
	@Test
	public void canAddEmployee() {
		Employee e = new Employee("Associate");
		er.addEmployee(e);
		assertNotNull(er.getAllEmployee());
	}

	@Test
	public void canGetEmployee() {
		Employee d = new Employee("Tester");
		er.addEmployee(d);
		assertEquals(1, er.getEmployee(1).getId());
	}

	@Test 
	public void canUpdateEmployee() {
		Employee emp = new Employee("Recuiter");
		er.addEmployee(emp);
		Employee e = er.getEmployee(1);
		e.setTitle("UpdatedTitle");
		er.updateEmployee(e);
		assertEquals("UpdatedTitle", er.getEmployee(1).getTitle());
	}
	
	@Test
	public void canDeleteEmployee() {
		Employee d = new Employee("Tester");
		d = er.addEmployee(d);
		int originalSize = er.getAllEmployee().size();
		er.deleteEmployee(d.getId());
		assertNotEquals(originalSize, er.getAllEmployee().size());

	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Tearing down test cases. Runs once");
		er = null;
	}

}

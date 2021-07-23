package dev.mai.tests;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import dev.mai.models.Department;
import dev.mai.repositories.DepartmentRepoImpl;


public class DepartmentRepoImplTest {
	
	static DepartmentRepoImpl dr;
	
	@BeforeClass
	public static void setUp() {
		dr = new DepartmentRepoImpl();
		Department d = new Department("HR");
		dr.addDepartment(d);
	}
	
	@Test
	public void canAddDepartment() {
		Department d = new Department("HR");
		dr.addDepartment(d);
		assertNotNull(dr.getAllDepartment());
	}

	@Test
	public void canGetDepartment() {
		Department d = new Department("Finance");
		dr.addDepartment(d);
		assertEquals(1, dr.getDepartment(1).getId());
	}
	
	@Test 
	public void canUpdateDepartment() {
		Department dept = new Department("Finance");
		dr.addDepartment(dept);
		Department d = dr.getDepartment(2);
		d.setTitle("UpdatedTitle");
		dr.updateDepartment(d);
		assertEquals("UpdatedTitle", dr.getDepartment(2).getTitle());
	}
	
	@Test
	public void canDeleteDepartment() {
		int originalSize = dr.getAllDepartment().size();
		dr.deleteDepartment(1);
		assertNotEquals(originalSize, dr.getAllDepartment().size());

	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Tearing down test cases. Runs once");
		dr = null;
	}

}

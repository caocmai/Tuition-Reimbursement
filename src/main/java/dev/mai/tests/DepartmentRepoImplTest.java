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
		d = dr.addDepartment(d);
		assertNotNull(dr.getDepartment(d.getId()));
	}
	
	@Test 
	public void canUpdateDepartment() {
		Department dept = new Department("Finance");
		dept = dr.addDepartment(dept);
		Department d = dr.getDepartment(dept.getId());
		d.setTitle("UpdatedTitle");
		dr.updateDepartment(d);
		assertEquals("UpdatedTitle", dr.getDepartment(dept.getId()).getTitle());
	}
	
	@Test
	public void canDeleteDepartment() {
		Department d = new Department("HR");
		d = dr.addDepartment(d);
		int originalSize = dr.getAllDepartment().size();
		dr.deleteDepartment(d.getId());
		assertNotEquals(originalSize, dr.getAllDepartment().size());

	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Tearing down test cases. Runs once");
		dr = null;
	}

}

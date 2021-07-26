//package dev.mai.tests;
//
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//
//import org.junit.AfterClass;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//import dev.mai.models.Form;
//import dev.mai.repositories.FormRepoImpl;
//
//public class FormRepoImplTest {
//	
//	static FormRepoImpl fr;
//	
//	@BeforeClass
//	public static void setUp() {
//		fr = new FormRepoImpl();
//	}
//	
//	@Test
//	public void canAddForm() {
//		Form f = new Form("Dallas", "Learn React", 240, "Grade", "Class", "None", 1235);
//		fr.addForm(f);
//		assertNotNull(fr.getForm(1));
//	}
//
//	@Test
//	public void canGetForm() {
//		Form f = new Form("Dallas", "Learn React", 240, "Grade", "Class", "None", 1235);
//		fr.addForm(f);
//		assertNotNull(fr.getForm(1));
//		assertEquals("Dallas", fr.getForm(1).getLocation());
//	}
//
//	@AfterClass
//	public static void tearDownAftfrClass() throws Exception {
//		System.out.println("Tearing down test cases. Runs once");
//		fr = null;
//	}
//
//}

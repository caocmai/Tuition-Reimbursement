package dev.mai.repositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dev.mai.models.Department;
import dev.mai.models.Employee;
import dev.mai.util.HibernateUtil;

public class EmployeeRepoImpl implements EmployeeRepo {
	
	@Override
	public Employee getEmployee(int id) {
		
		Session sess = HibernateUtil.getSession();
		Employee emp = null;
		
		try {
			emp = sess.get(Employee.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		return emp;
	}

	@Override
	public Employee addEmployee(Employee emp) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;
		
//		Employee manager = new Employee("Jon");
//		Employee emp1 = new Employee("Emp1");
//		Employee emp2 = new Employee("Emp2");
//		
//		emp1.setSupervisor(manager);
//		emp2.setSupervisor(manager);
		
//		List<Employee> employees = new ArrayList<>(Arrays.asList(emp1, emp2));
//		manager.setSubordinates(employees);
		
		// can set it one by one or as a list
//		manager.getSubordinates().add(emp1);
//		manager.getSubordinates().add(emp2);

		try {
			tx = sess.beginTransaction();
			int id = (int)sess.save(emp);
			emp.setId(id);
			
//			sess.save(manager);
//			sess.save(emp1);
//			sess.save(emp2);
//		
			
			tx.commit();
		
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			emp = null;
		} finally {
			sess.close();
		}
		
		return emp;
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> employees = null; 
		Session sess = HibernateUtil.getSession();
		try {
			employees = sess.createQuery("FROM Employee").list();
		} catch (HibernateException e) {
			e.printStackTrace();
			sess.getTransaction().rollback();
		} finally {
			sess.close();
		}

		return employees;
	}

	@Override
	public Employee updateEmployee(Employee changeE) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = sess.beginTransaction();
			sess.update(changeE);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			return null;
		} finally {
			sess.close();
		}
		return changeE;
	}

	@Override
	public Employee deleteEmployee(int id) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;
		Employee emp = sess.get(Employee.class, id);
		
		try {
			tx = sess.beginTransaction();
			sess.delete(emp);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			return null;
		} finally {
			sess.close();
		}
		return emp;
	}
	


}

package dev.mai.repositories;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

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

		try {
			sess.beginTransaction();
			int id = (int)sess.save(emp);
			emp.setId(id);
			sess.getTransaction().commit();
		
		} catch (HibernateException e) {
			e.printStackTrace();
			sess.getTransaction().rollback(); // if something is wrong so get the transaction and rollback
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
			sess.getTransaction().rollback(); // if something is wrong so get the transaction and rollback
		} finally {
			sess.close();
		}

		return employees;
	}
	


}

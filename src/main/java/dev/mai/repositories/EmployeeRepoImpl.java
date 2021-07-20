package dev.mai.repositories;

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

}

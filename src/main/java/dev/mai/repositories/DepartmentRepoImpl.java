package dev.mai.repositories;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import dev.mai.models.Department;
import dev.mai.util.HibernateUtil;

public class DepartmentRepoImpl implements DepartmentRepo {

	@Override
	public Department addDepartment(Department d) {
		Session sess = HibernateUtil.getSession();

		try {
			sess.beginTransaction();
			int id = (int)sess.save(d);
			d.setId(id);
			sess.getTransaction().commit();
		
		} catch (HibernateException e) {
			e.printStackTrace();
			sess.getTransaction().rollback(); // if something is wrong so get the transaction and rollback
			d = null;
		} finally {
			sess.close();
		}
		
		return d;
	}

	@Override
	public Department getDepartment(int id) {
		Session sess = HibernateUtil.getSession();
		Department dept = null;
		try {
			dept = sess.get(Department.class, id);
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		return dept;
	}

	@Override
	public List<Department> getAllDepartment() {
		List<Department> departments = null; 
		Session sess = HibernateUtil.getSession();
		try {
			departments = sess.createQuery("FROM Department").list();
		} catch (HibernateException e) {
			e.printStackTrace();
			sess.getTransaction().rollback(); // if something is wrong so get the transaction and rollback
		} finally {
			sess.close();
		}

		return departments;
	}

}

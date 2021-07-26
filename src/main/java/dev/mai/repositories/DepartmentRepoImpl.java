package dev.mai.repositories;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import dev.mai.models.Department;
import dev.mai.models.Employee;
import dev.mai.models.Request;
import dev.mai.util.HibernateUtil;

public class DepartmentRepoImpl implements DepartmentRepo {

	@Override
	public Department addDepartment(Department d) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = sess.beginTransaction();
			int id = (int)sess.save(d);
			d.setId(id);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
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
			sess.getTransaction().rollback(); 
		} finally {
			sess.close();
		}

		return departments;
	}

	@Override
	public Department updateDepartment(Department changeD) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = sess.beginTransaction();
			sess.update(changeD);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			return null;
		} finally {
			sess.close();
		}
		
		return changeD;
	}

	@Override
	public Department deleteDepartment(int id) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;
		Department d = sess.get(Department.class, id);
		
		try {
			tx = sess.beginTransaction();
			sess.delete(d);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			return null;
		} finally {
			sess.close();
		}
		return d;
	}

	@Override
	public Department getDepartmentByHead(Employee head) {
		Department dept = null;
		Session sess = HibernateUtil.getSession();
		
		try {
			Query q = sess.createQuery("FROM Department D WHERE D.head.id=:emp");
			q.setParameter("emp", head.getId());
			dept = (Department) q.uniqueResult();
	
		} catch (HibernateException e) {
			e.printStackTrace();
			sess.getTransaction().rollback();
		} finally {
			sess.close();
		}
		
		return dept;
	}

}

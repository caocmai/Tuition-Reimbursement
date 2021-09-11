package dev.mai.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import dev.mai.models.Employee;
import dev.mai.models.Form;
import dev.mai.models.Request;
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
		
		try {
			tx = sess.beginTransaction();
			int id = (int)sess.save(emp);
			emp.setId(id);
			
			tx.commit();
			
		} catch (HibernateException er) {
			er.printStackTrace();
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

	@Override
	public Employee getEmployByLogin(String username, String password) {
		Employee employee = null; 
		Session sess = HibernateUtil.getSession();
		try {
			Query q = sess.createQuery("FROM Employee E WHERE E.username=:username AND E.password=:password");
			q.setParameter("username", username);
			q.setParameter("password", password);
			employee = (Employee)q.setMaxResults(1).uniqueResult();
			System.out.println(employee);
//			employee = (Employee) sess.createQuery().uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
			sess.getTransaction().rollback();
		} finally {
			sess.close();
		}

		return employee;
	}

	@Override
	public List<Request> getEmployeeRequests(Employee emp) {
		List<Request> requests = null;
		Session sess = HibernateUtil.getSession();
		
		
//		String sql = "FROM Request R WHERE R.employee_e_id=?";
		
		
		
//		Session sess = HibernateUtil.getSession()
//		Connection con = sess.connection();
//		PreparedStatement pstmt = con.prepareStatement(sql);

		
		try {
			Query q = sess.createQuery("FROM Request R WHERE R.employee.id=:emp");
			q.setParameter("emp", emp.getId());
			requests =  q.list();
			
//			System.out.println(requests + "\n\n\n\n\n\n");
//			PreparedStatement ps = conn.prepareStatement(sql);
			
			
//			Query spSQLQuery = sess.createSQLQuery("SELECT * FROM requests r WHERE r.employee_e_id=:id");
//			spSQLQuery.setParameter("id", 1);
//			
//			requests = spSQLQuery.list();

	
		} catch (HibernateException e) {
			e.printStackTrace();
			sess.getTransaction().rollback();
		} finally {
			sess.close();
		}
		
		return requests;
	}

	//not using
	@Override
	public List<Request> getPendingRequestFromSuper(Employee superEmp) {
		
		List<Request> requests = null;
//		Session sess = HibernateUtil.getSession();
//		try {
//			Query q = sess.createQuery("FROM Request R WHERE R.employee=:emp");
//			q.setParameter("emp", emp);
//			requests =  q.list();
//
//		} catch (HibernateException e) {
//			e.printStackTrace();
//			sess.getTransaction().rollback();
//		} finally {
//			sess.close();
//		}
//		
		return requests;
		
	}

	@Override
	public List<Request> getPendingAppRequests(Employee loginEmp) {
		List<Request> requests = null;
		Session sess = HibernateUtil.getSession();
		
		try {
			Query q = sess.createQuery("FROM Request R WHERE R.employee.id=:emp AND R.benCoAppve=true AND R.grade=:grade");
			q.setParameter("emp", loginEmp.getId());
			q.setParameter("grade", null);

			requests =  q.list();
			System.out.println(requests);
	
		} catch (HibernateException e) {
			e.printStackTrace();
			sess.getTransaction().rollback();
		} finally {
			sess.close();
		}
		
		return requests;
	}
	


}

package dev.mai.repositories;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import dev.mai.models.Employee;
import dev.mai.models.Request;
import dev.mai.util.HibernateUtil;

public class RequestRepoImpl implements RequestRepo{

	@Override
	public Request addRequest(Request r) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = sess.beginTransaction();
			int id = (int)sess.save(r);
			r.setId(id);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			r = null;
		} finally {
			sess.close();
		}
		
		return r;
	}

	@Override
	public Request getRequest(int id) {
		Session sess = HibernateUtil.getSession();
		Request r = null;
		
		try {
			r = sess.get(Request.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		return r;
	}

	@Override
	public List<Request> getAllRequest() {
		List<Request> requests = null; 
		Session sess = HibernateUtil.getSession();
		try {
			requests = sess.createQuery("FROM Request").list();
		} catch (HibernateException e) {
			e.printStackTrace();
			sess.getTransaction().rollback();
		} finally {
			sess.close();
		}

		return requests;
	}

	@Override
	public Request updateRequest(Request changeR) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = sess.beginTransaction();
			sess.update(changeR);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			return null;
		} finally {
			sess.close();
		}
		return changeR;
	}

	@Override
	public Request deleteRequest(int id) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;
		Request r = sess.get(Request.class, id);
		
		try {
			tx = sess.beginTransaction();
			sess.delete(r);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			return null;
		} finally {
			sess.close();
		}
		return r;
	}

	@Override
	public List<Request> getPendingRequests(Employee e) {
		List<Request> requests = null;
		Session sess = HibernateUtil.getSession();
		
		try {
			Query q = sess.createQuery("FROM Request R WHERE R.employee.id=:emp AND R.benCoAppveFinal=false");
			q.setParameter("emp", e.getId());

			requests =  q.list();
			
	
		} catch (HibernateException er) {
			er.printStackTrace();
			sess.getTransaction().rollback();
		} finally {
			sess.close();
		}
		
		return requests;
	}
	
	

}

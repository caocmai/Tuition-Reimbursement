package dev.mai.repositories;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dev.mai.models.MoreInfoRequest;
import dev.mai.util.HibernateUtil;

public class MoreInfoRequestImpl implements MoreInfoRequestRepo {

	@Override
	public MoreInfoRequest addMoreInfoRequest(MoreInfoRequest m) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = sess.beginTransaction();
			int id = (int)sess.save(m);
			m.setId(id);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			m = null;
		} finally {
			sess.close();
		}
		
		return m;
	}

	@Override
	public MoreInfoRequest getMoreInfoRequest(int id) {
		Session sess = HibernateUtil.getSession();
		MoreInfoRequest m = null;
		
		try {
			m = sess.get(MoreInfoRequest.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		return m;
	}

	@Override
	public List<MoreInfoRequest> getAllMoreInfoRequests() {
		List<MoreInfoRequest> requests = null; 
		Session sess = HibernateUtil.getSession();
		try {
			requests = sess.createQuery("FROM MoreInfoRequest").list();
		} catch (HibernateException e) {
			e.printStackTrace();
			sess.getTransaction().rollback();
		} finally {
			sess.close();
		}

		return requests;
	}

	@Override
	public MoreInfoRequest updateMoreInfoRequest(MoreInfoRequest changeM) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = sess.beginTransaction();
			sess.update(changeM);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			return null;
		} finally {
			sess.close();
		}
		return changeM;
	}

	@Override
	public MoreInfoRequest deleteMoreInfoRequest(int id) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;
		MoreInfoRequest r = sess.get(MoreInfoRequest.class, id);
		
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

}

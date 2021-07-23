package dev.mai.repositories;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dev.mai.models.Form;
import dev.mai.util.HibernateUtil;

public class FormRepoImpl implements FormRepo {

	@Override
	public Form addForm(Form f) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = sess.beginTransaction();
			int id = (int)sess.save(f);
			f.setId(id);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			f = null;
		} finally {
			sess.close();
		}
		
		return f;
	}

	@Override
	public Form getForm(int id) {
		Session sess = HibernateUtil.getSession();
		Form f = null;
		
		try {
			f = sess.get(Form.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		return f;
	}

}

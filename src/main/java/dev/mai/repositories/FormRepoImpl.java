package dev.mai.repositories;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dev.mai.models.Employee;
import dev.mai.models.Form;
import dev.mai.models.Request;
import dev.mai.util.HibernateUtil;

public class FormRepoImpl implements FormRepo {

	@Override
	public Form addForm(Form f, Employee e) {
		Date date = new Date();
		boolean isUrgent = false;
		if (f.getStartDate() < date.getTime() + 604800000) {
			isUrgent = true;
		}
		
		boolean supAppve = false;
		boolean deptAppve = false;
		boolean benCoAppv = false;
		
		switch (f.getSupplementInfo()) {
		case "BenCo Approval":
			benCoAppv = true;
		case "Dept Approval":
			deptAppve = true;
		case "Sup Approval":
			supAppve = true;
		default:
			break;
		}
		
		int eventCost = calEventCost(f.getEventType(), f.getCost());
		int totalCost = calcTotalApproveAmount(e);
		int fundsLeft = 1000 - (e.getTotalReimbursement() + totalCost); 
		
		
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = sess.beginTransaction();
			int id = (int)sess.save(f);
			f.setId(id);
			
			Request r = new Request(f.getStartDate(), isUrgent, f, e);
			r.setSuperAppve(supAppve);
			r.setDeptAppve(deptAppve);
			r.setBenCoAppve(benCoAppv);
			
			if (eventCost >= fundsLeft) {
				r.setAmountAppve(fundsLeft);				
			} else {
				r.setAmountAppve(eventCost);
			}
			
			sess.save(r);
			
			tx.commit();
		} catch (HibernateException er) {
			er.printStackTrace();
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
	
	private int calcTotalApproveAmount(Employee e) {
		RequestRepoImpl rr = new RequestRepoImpl();
		List<Request> requests = rr.getPendingRequests(e);
		
		int cost = 0;
		
		for (Request r : requests) {
			System.out.println(r);
			cost += r.getAmountAppve(); 
		}
		
		return cost;
	}
	
	
	private int calEventCost(String eventType, int cost) {
		int eventReimbursement = 0;
		
		if (eventType.equalsIgnoreCase("UniversityCourses")) {
			eventReimbursement = (int) (cost * .80);
		} else if (eventType.equalsIgnoreCase("Seminars")) {
			eventReimbursement = (int) (cost * .60);
		} else if (eventType.equalsIgnoreCase("CertificationPreparationClasses")) {
			eventReimbursement = (int) (cost * .75);

		} else if (eventType.equalsIgnoreCase("Certification")) {
			eventReimbursement = (int) (cost * 1.00);

		} else if (eventType.equalsIgnoreCase("TechnicalTraining")) {
			eventReimbursement = (int) (cost * .90);

		} else if (eventType.equalsIgnoreCase("Other")) {
			eventReimbursement = (int) (cost * .30);

		}
		
		return eventReimbursement;
	}

}

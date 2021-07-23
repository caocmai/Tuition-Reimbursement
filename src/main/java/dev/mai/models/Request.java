package dev.mai.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="requests")
public class Request {
	
	@Id
	@Column(name="r_id", updatable=false)
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="start_request")
	private long startRequest;
	private boolean urgent;
	
	@Column(name="super_appve")
	private boolean superAppve;
	
	@Column(name="dept_appve")
	private boolean deptAppve;
	
	@Column(name="ben_co_appve")
	private boolean benCoAppve;
	
	private String grade;
	
	@Column(name="ben_co_appve_final")
	private boolean benCoAppveFinal;
	
	@Column(name="amount_appve")
	private int amountAppve;
	
	@Column(name="amount_above_reason")
	private String amountAboveReason;
	
	private boolean denial;
	
	@Column(name="denial_reason")
	private String denialReason;
	
	@OneToOne
	private Form form;
	
	@OneToMany(mappedBy="request")
	private List<MoreInfoRequest> infoRequests;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getStartRequest() {
		return startRequest;
	}

	public void setStartRequest(long startRequest) {
		this.startRequest = startRequest;
	}

	public boolean isUrgent() {
		return urgent;
	}

	public void setUrgent(boolean urgent) {
		this.urgent = urgent;
	}

	public boolean isSuperAppve() {
		return superAppve;
	}

	public void setSuperAppve(boolean superAppve) {
		this.superAppve = superAppve;
	}

	public boolean isDeptAppve() {
		return deptAppve;
	}

	public void setDeptAppve(boolean deptAppve) {
		this.deptAppve = deptAppve;
	}

	public boolean isBenCoAppve() {
		return benCoAppve;
	}

	public void setBenCoAppve(boolean benCoAppve) {
		this.benCoAppve = benCoAppve;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public boolean isBenCoAppveFinal() {
		return benCoAppveFinal;
	}

	public void setBenCoAppveFinal(boolean benCoAppveFinal) {
		this.benCoAppveFinal = benCoAppveFinal;
	}

	public int getAmountAppve() {
		return amountAppve;
	}

	public void setAmountAppve(int amountAppve) {
		this.amountAppve = amountAppve;
	}

	public String getAmountAboveReason() {
		return amountAboveReason;
	}

	public void setAmountAboveReason(String amountAboveReason) {
		this.amountAboveReason = amountAboveReason;
	}

	public boolean isDenial() {
		return denial;
	}

	public void setDenial(boolean denial) {
		this.denial = denial;
	}

	public String getDenialReason() {
		return denialReason;
	}

	public void setDenialReason(String denialReason) {
		this.denialReason = denialReason;
	}

	public Form getForm() {
		return form;
	}

	public void setForm(Form form) {
		this.form = form;
	}

	public List<MoreInfoRequest> getInfoRequests() {
		return infoRequests;
	}

	public void setInfoRequests(List<MoreInfoRequest> infoRequests) {
		this.infoRequests = infoRequests;
	}
	
	
	
}

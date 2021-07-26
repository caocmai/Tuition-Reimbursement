package dev.mai.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Employee employee;
	
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
	
	@OneToOne(fetch=FetchType.EAGER)
	private Form form;
	
	@Column(name="more_info_needed")
	private boolean needMoreInfo;
	
	// currently not using!
	@Column(name="more_info_id")
	private int moreInfoId;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="more_info_request")
	private List<MoreInfoRequest> moreInfoRequests = new ArrayList<>();
	
	public Request() {
		super();
	}
	
	public Request(long startRequest, boolean urgent, Form form) {
		super();
		this.startRequest = startRequest;
		this.urgent = urgent;
		this.form = form;
	}
	
	public Request(long startRequest, boolean urgent, Form form, Employee emp) {
		super();
		this.startRequest = startRequest;
		this.urgent = urgent;
		this.form = form;
		this.employee = emp;
	}

	public Request(int id, long startRequest, boolean urgent, Form form, Employee emp) {
		super();
		this.id = id;
		this.startRequest = startRequest;
		this.urgent = urgent;
		this.form = form;
		this.employee = emp;
	}

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

	public boolean isNeedMoreInfo() {
		return needMoreInfo;
	}

	public void setNeedMoreInfo(boolean needMoreInfo) {
		this.needMoreInfo = needMoreInfo;
	}

	public int getMoreInfoId() {
		return moreInfoId;
	}

	public void setMoreInfoId(int moreInfoId) {
		this.moreInfoId = moreInfoId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	

	public List<MoreInfoRequest> getMoreInfoRequests() {
		return moreInfoRequests;
	}

	public void setMoreInfoRequests(List<MoreInfoRequest> moreInfoRequests) {
		this.moreInfoRequests = moreInfoRequests;
	}

	@Override
	public String toString() {
		return "Request [id=" + id + ", employee=" + employee + ", startRequest=" + startRequest + ", urgent=" + urgent
				+ ", superAppve=" + superAppve + ", deptAppve=" + deptAppve + ", benCoAppve=" + benCoAppve + ", grade="
				+ grade + ", benCoAppveFinal=" + benCoAppveFinal + ", amountAppve=" + amountAppve
				+ ", amountAboveReason=" + amountAboveReason + ", denial=" + denial + ", denialReason=" + denialReason
				+ ", form=" + form + ", moreInfoId=" + moreInfoId + "]";
	}
	
	
	
	
	
}

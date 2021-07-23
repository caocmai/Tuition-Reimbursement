package dev.mai.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="more_info_requests")
public class MoreInfoRequest {
	
	@Id
	@Column(name="m_id", updatable=false)
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	
	@OneToOne
	@JoinColumn(name="from_employee_id")
	private Employee fromEmpolyee;
	
	@OneToOne
	@JoinColumn(name="to_employee_id")
	private Employee toEmployee;
	
	private String description;
	private boolean fulfilled;
	
	@ManyToOne
	private Request request;

	public MoreInfoRequest() {
		super();
	}
	
	public MoreInfoRequest(Employee fromEmpolyee, Employee toEmployee, String description, boolean fulfilled,
			Request request) {
		super();
		this.fromEmpolyee = fromEmpolyee;
		this.toEmployee = toEmployee;
		this.description = description;
		this.fulfilled = fulfilled;
		this.request = request;
	}

	

	public MoreInfoRequest(int id, Employee fromEmpolyee, Employee toEmployee, String description, boolean fulfilled,
			Request request) {
		super();
		this.id = id;
		this.fromEmpolyee = fromEmpolyee;
		this.toEmployee = toEmployee;
		this.description = description;
		this.fulfilled = fulfilled;
		this.request = request;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Employee getFromEmpolyee() {
		return fromEmpolyee;
	}

	public void setFromEmpolyee(Employee fromEmpolyee) {
		this.fromEmpolyee = fromEmpolyee;
	}

	public Employee getToEmployee() {
		return toEmployee;
	}

	public void setToEmployee(Employee toEmployee) {
		this.toEmployee = toEmployee;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isFulfilled() {
		return fulfilled;
	}

	public void setFulfilled(boolean fulfilled) {
		this.fulfilled = fulfilled;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	} 
	
	

}

package dev.mai.models;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
	
//	@ManyToOne(fetch = FetchType.EAGER, optional = true, cascade = CascadeType.PERSIST)
//	@JoinTable(name = "request_moreinfo", joinColumns = @JoinColumn(name = "r_id", referencedColumnName = "id", nullable = true), 
//		inverseJoinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id", nullable = true))
//	@JsonIgnoreProperties("storyList")
//	@JoinTable(name="req_moreinfo",
//				joinColumns={@JoinColumn(name="r_id")},
//				inverseJoinColumns={@JoinColumn(name="m_id")})
//    @JsonIgnoreProperties("moreInfoRequests")
//	private Request request;
	

	public MoreInfoRequest() {
		super();
	}
	
	public MoreInfoRequest(Employee fromEmpolyee, Employee toEmployee, String description, boolean fulfilled) {
		super();
		this.fromEmpolyee = fromEmpolyee;
		this.toEmployee = toEmployee;
		this.description = description;
		this.fulfilled = fulfilled;
	}


	public MoreInfoRequest(int id, Employee fromEmpolyee, Employee toEmployee, String description, boolean fulfilled) {
		super();
		this.id = id;
		this.fromEmpolyee = fromEmpolyee;
		this.toEmployee = toEmployee;
		this.description = description;
		this.fulfilled = fulfilled;
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
	
	
//
//
//	public Request getRequest() {
//		return request;
//	}
//
//	public void setRequest(Request request) {
//		this.request = request;
//	}

	@Override
	public String toString() {
		return "MoreInfoRequest [id=" + id + ", fromEmpolyee=" + fromEmpolyee + ", toEmployee=" + toEmployee
				+ ", description=" + description + ", fulfilled=" + fulfilled + "]";
	} 
	
	
	
	

}

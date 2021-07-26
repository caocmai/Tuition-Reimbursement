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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="employees")
public class Employee {
	
	@Id
	@Column(name="e_id", updatable=false)
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	
//  "Supervisor" ||  "BenCo" || "DeptHead"
	@Column(name="title", nullable=false)
	private String title;
	
	private String username;
	
	private String password;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="total_reimbursement", nullable=false, columnDefinition="integer default 25")
	private int totalReimbursement;
	
	@Column(name="reset_date", nullable=false, columnDefinition="bigint default 250000")
	private long resetDate;
	
	@Column(name="is_ben_co")
	private boolean isBenCo;
	
	@Column(name="super_id")
	private int supervisorId;
	
	@Column(name="dept_id")
	private int deptId;
	
//	@OneToMany(fetch=FetchType.EAGER)
//	@JoinTable(name="employee_request", joinColumns=@JoinColumn(name="e_id"), inverseJoinColumns=@JoinColumn(name="r_id"))
//	@Fetch(value = FetchMode.SUBSELECT)
//	@JoinTable(name="emp_requests",
//    joinColumns={@JoinColumn(name="e_id")},
//    inverseJoinColumns={@JoinColumn(name="r_id")})
//	private List<Request> requests = new ArrayList<Request>();
	
	
	public Employee() {
		super();
	}
	
	public Employee(String title) {
		super();
		this.title = title;
	}

	public Employee(String title, String username, String password, String firstName, String lastName,
			int totalReimbursement, long resetDate, boolean isBenCo) {
		super();
		this.title = title;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.totalReimbursement = totalReimbursement;
		this.resetDate = resetDate;
		this.isBenCo = isBenCo;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getTotalReimbursement() {
		return totalReimbursement;
	}

	public void setTotalReimbursement(int totalReimbursement) {
		this.totalReimbursement = totalReimbursement;
	}

	public long getResetDate() {
		return resetDate;
	}

	public void setResetDate(long resetDate) {
		this.resetDate = resetDate;
	}

	public boolean isBenCo() {
		return isBenCo;
	}

	public void setBenCo(boolean isBenCo) {
		this.isBenCo = isBenCo;
	}

//	@JsonBackReference
	public int getSupervisorId() {
		return supervisorId;
	}

	public void setSupervisorId(int supervisorId) {
		this.supervisorId = supervisorId;
	}

//	@JsonManagedReference
//	public List<Employee> getSubordinates() {
//		return subordinates;
//	}
//
//	public void setSubordinates(List<Employee> subordinates) {
//		this.subordinates = subordinates;
//	}

	

//	public List<Request> getRequests() {
//		return requests;
//	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

//	public void setRequests(List<Request> requests) {
//		this.requests = requests;
//	}

//	@Override
//	public String toString() {
//		return "Employee [id=" + id + ", title=" + title + ", username=" + username + ", password=" + password
//				+ ", firstName=" + firstName + ", lastName=" + lastName + ", totalReimbursement=" + totalReimbursement
//				+ ", resetDate=" + resetDate + ", isBenCo=" + isBenCo + "]";
//	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", title=" + title + ", username=" + username + ", password=" + password
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", totalReimbursement=" + totalReimbursement
				+ ", resetDate=" + resetDate + ", isBenCo=" + isBenCo + ", supervisorId=" + supervisorId + ", deptId=" + deptId
				+ "]";
	}
	
	



}

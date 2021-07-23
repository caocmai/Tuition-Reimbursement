package dev.mai.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="employees")
public class Employee {
	
	@Id
	@Column(name="e_id", updatable=false)
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	
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

	@ManyToOne
	@JoinColumn(name="s_id", nullable=true)
	private Employee supervisor;
	
	@OneToMany(mappedBy="supervisor")
	private List<Employee> subordinates = new ArrayList<Employee>();
	
	@ManyToOne
	@JoinColumn(name="department_id", nullable=true)
	private Department dept;
	
	@OneToMany(mappedBy="employee")
	private List<Request> requests = new ArrayList<Request>();
	
	
	public Employee() {
		super();
	}
	
	public Employee(String title) {
		super();
		this.title = title;
	}

	public Employee(String title, String username, String password, String firstName, String lastName,
			int totalReimbursement, long resetDate, boolean isBenCo, Department dept) {
		super();
		this.title = title;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.totalReimbursement = totalReimbursement;
		this.resetDate = resetDate;
		this.isBenCo = isBenCo;
		this.dept = dept;
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

	public Employee getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Employee supervisor) {
		this.supervisor = supervisor;
	}

	public List<Employee> getSubordinates() {
		return subordinates;
	}

	public void setSubordinates(List<Employee> subordinates) {
		this.subordinates = subordinates;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public List<Request> getRequests() {
		return requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}
	
	
	
}

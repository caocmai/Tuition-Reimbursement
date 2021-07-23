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
//	@JoinColumn(name="s_id", nullable=true)
	private Employee supervisor;
	
	@OneToMany(mappedBy="supervisor")
	private List<Employee> subordinates = new ArrayList<Employee>();
	
	@ManyToOne
//	@JoinColumn(name="department", nullable=true)
	private Department dept;
	
	
	public Employee() {
		super();
	}
	
	public Employee(String title) {
		super();
		this.title = title;
	}

	public Employee(String title, String firstName, String lastName, int totalReimbursement, long resetDate,
			boolean isBenCo, Employee supervisor, List<Employee> subordinates, Department dept) {
		super();
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.totalReimbursement = totalReimbursement;
		this.resetDate = resetDate;
		this.isBenCo = isBenCo;
		this.supervisor = supervisor;
		this.subordinates = subordinates;
		this.dept = dept;
	}


	public Employee(int id, String title, String firstName, String lastName, int totalReimbursement, long resetDate,
			boolean isBenCo, Employee supervisor, List<Employee> subordinates, Department dept) {
		super();
		this.id = id;
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.totalReimbursement = totalReimbursement;
		this.resetDate = resetDate;
		this.isBenCo = isBenCo;
		this.supervisor = supervisor;
		this.subordinates = subordinates;
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

}

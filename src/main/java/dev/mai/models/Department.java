package dev.mai.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="departments")
public class Department {
	
	@Id
	@Column(name="d_id", updatable=false)
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="title", nullable=false)
	private String title;
	
	@OneToOne
	@JoinColumn(name="head_id", nullable=true)
	private Employee head;
	
	@OneToMany(mappedBy="dept")
	@JsonManagedReference
	private List<Employee> employees = new ArrayList<Employee>();

	public Department() {
		super();
	}
	
	public Department(String title) {
		super();
		this.title = title;
	}

	
	public Department(String title, Employee head) {
		super();
		this.title = title;
		this.head = head;
	}

	public Department(int id, String title, Employee head) {
		super();
		this.id = id;
		this.title = title;
		this.head = head;
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


	public Employee getHead() {
		return head;
	}


	public void setHead(Employee head) {
		this.head = head;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", title=" + title + ", head=" + head + ", employees=" + employees + "]";
	}
	
	

}

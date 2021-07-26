package dev.mai.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="departments")
public class Department {
	
	@Id
	@Column(name="d_id", updatable=false)
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="title", nullable=false)
	private String title;
	
	@Column(name="head_id")
	private int headEmpId;
	
	public Department() {
		super();
	}
	
	public Department(String title) {
		super();
		this.title = title;
	}

	
	public Department(String title, int headEmpId) {
		super();
		this.title = title;
		this.headEmpId = headEmpId;
	}

	public Department(int id, String title, int headEmpId) {
		super();
		this.id = id;
		this.title = title;
		this.headEmpId = headEmpId;
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


	public int getHeadEmpId() {
		return headEmpId;
	}


	public void setHeadEmpId(int headEmpId) {
		this.headEmpId = headEmpId;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", title=" + title + ", headEmpId=" + headEmpId + "]";
	}

//	public List<Employee> getEmployees() {
//		return employees;
//	}
//
//	public void setEmployees(List<Employee> employees) {
//		this.employees = employees;
//	}


	

}

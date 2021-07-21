package dev.mai.models;

import javax.persistence.*;

@Entity
@Table(name="employees")
public class Employee {
	
	@Id
	@Column(name="m_id", updatable=false)
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="title", nullable=false)
	private String title;

	public Employee() {
		super();
	}

	public Employee(String title) {
		super();
		this.title = title;
	}

	public Employee(int id, String title) {
		super();
		this.id = id;
		this.title = title;
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

}

package dev.mai.models;

import javax.persistence.*;

@Entity
@Table(name="departments")
public class Department {
	
	@Id
	@Column(name="d_id", updatable=false)
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="title", nullable=false)
	private String title;
	
	@JoinColumn(table="employees", name="e_id", nullable=true)
	private int deptHeadId;
	
	

}

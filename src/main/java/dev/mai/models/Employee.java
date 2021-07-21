package dev.mai.models;

import javax.persistence.*;

@Entity
@Table(name="employees")
public class Employee {
	
	@Id
	@Column(name="e_id", updatable=false)
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="title", nullable=false)
	private String title;
	
	@Column(name="first_name", nullable=false)
	private String firstName;
	
	@Column(name="last_name", nullable=false)
	private String lastName;
	
	@Column(name="total_reimbursement", nullable=false, columnDefinition="integer default 25")
	private int totalReimbursement;
	
	@Column(name="reset_date", nullable=false, columnDefinition="bigint default 250000")
	private long resetDate;
	
	@Column(name="is_ben_co")
	private boolean isBenCo;

	@JoinColumn(name="e_id", nullable=true)
	private int superId;

	public Employee() {
		super();
	}
	
	public Employee(String title, String firstName, String lastName, int totalReimbursement, long resetDate,
			boolean isBenCo, int superId) {
		super();
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.totalReimbursement = totalReimbursement;
		this.resetDate = resetDate;
		this.isBenCo = isBenCo;
		this.superId = superId;
	}
	
	public Employee(int id, String title, String firstName, String lastName, int totalReimbursement, long resetDate,
			boolean isBenCo, int superId) {
		super();
		this.id = id;
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.totalReimbursement = totalReimbursement;
		this.resetDate = resetDate;
		this.isBenCo = isBenCo;
		this.superId = superId;
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

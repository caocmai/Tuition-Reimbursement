package dev.mai.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="requests")
public class Request {
	
	@Id
	@Column(name="r_id", updatable=false)
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	
	private long startRequest;
	private boolean urgent;
	private boolean superAppve;
	private boolean deptAppve;
	private boolean benCoAppve;
	private String grade;
	private boolean benCoAppveFinal;
	private int amountAppve;
	private String amountAboveReason;
	private boolean denial;
	private String denialReason;
	
	@OneToOne
	private Form form;
	
	@OneToMany
	private List<MoreInfoRequest> infoRequests;
	
}

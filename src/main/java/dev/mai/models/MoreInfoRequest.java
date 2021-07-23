package dev.mai.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="more_info_requests")
public class MoreInfoRequest {
	
	@Id
	@Column(name="m_id", updatable=false)
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	
	private Employee fromEmpolyee;
	private Employee toEmployee;
	private String description;
	private boolean fulfilled;

}

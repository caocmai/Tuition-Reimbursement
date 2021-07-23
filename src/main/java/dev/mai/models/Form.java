package dev.mai.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="forms")

public class Form {
//	private long date;
//	private long time;
	@Id
	@Column(name="f_id", updatable=false)
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	
	private String location;
	private String description;
	private int cost;
	private String gradingType;
//	University Courses 80%, Seminars 60%, Certification Preparation Classes 75%, 
//	Certification 100%, Technical Training 90%, Other 30%. 
	private String eventType;
	// tentatively as a string should be attachment
	private String supplementInfo;
	private long offTime;
	
	
}

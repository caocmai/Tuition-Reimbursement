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
	
	// This will be either presentation, normal grading, or pass/fail 
	@Column(name="grading_type")
	private String gradingType;
	
//	University Courses 80%, Seminars 60%, Certification Preparation Classes 75%, 
//	Certification 100%, Technical Training 90%, Other 30%. 
	@Column(name="event_type")
	private String eventType;
	
	// tentatively as a string should be attachment
	@Column(name="supplement_info")
	private String supplementInfo;
	
	@Column(name="time_off")
	private long timeOff;
	
	public Form() {
		super();
	}

	public Form(String location, String description, int cost, String gradingType, String eventType,
			String supplementInfo, long timeOff) {
		super();
		this.location = location;
		this.description = description;
		this.cost = cost;
		this.gradingType = gradingType;
		this.eventType = eventType;
		this.supplementInfo = supplementInfo;
		this.timeOff = timeOff;
	}

	public Form(int id, String location, String description, int cost, String gradingType, String eventType,
			String supplementInfo, long timeOff) {
		super();
		this.id = id;
		this.location = location;
		this.description = description;
		this.cost = cost;
		this.gradingType = gradingType;
		this.eventType = eventType;
		this.supplementInfo = supplementInfo;
		this.timeOff = timeOff;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getGradingType() {
		return gradingType;
	}

	public void setGradingType(String gradingType) {
		this.gradingType = gradingType;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getSupplementInfo() {
		return supplementInfo;
	}

	public void setSupplementInfo(String supplementInfo) {
		this.supplementInfo = supplementInfo;
	}

	public long getTimeOff() {
		return timeOff;
	}

	public void setTimeOff(long timeOff) {
		this.timeOff = timeOff;
	}

	@Override
	public String toString() {
		return "Form [id=" + id + ", location=" + location + ", description=" + description + ", cost=" + cost
				+ ", gradingType=" + gradingType + ", eventType=" + eventType + ", supplementInfo=" + supplementInfo
				+ ", timeOff=" + timeOff + "]";
	}
	
	
	
	
}

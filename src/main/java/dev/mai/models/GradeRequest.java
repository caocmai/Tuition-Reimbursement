package dev.mai.models;

public class GradeRequest {
	
	private String id;
	private String grade;
	
	public GradeRequest() {
		super();
	}
	public GradeRequest(String id, String grade) {
		super();
		this.id = id;
		this.grade = grade;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	

}

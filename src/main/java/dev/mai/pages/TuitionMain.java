package dev.mai.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TuitionMain {
	public WebDriver driver;
	
	@FindBy(id="username")
	public WebElement username;
	
	@FindBy(id="password")
	public WebElement password;
	
	@FindBy(id="loginBtn")
	public WebElement loginBtn;
	
	@FindBy(id="startRequest")
	public WebElement request;
	
	@FindBy(id="myRequestBtn")
	public WebElement myRequestBtn;
	
	@FindBy(id="getRequests")
	public WebElement getRequests;
	
	
	@FindBy(id="location")
	public WebElement location;
	
	@FindBy(id="description")
	public WebElement description;
	
	@FindBy(id="cost")
	public WebElement cost;
	
	@FindBy(id="eventType")
	public WebElement eventType;
	
	@FindBy(id="gradingType")
	public WebElement gradingType;
	
	@FindBy(id="attachment")
	public WebElement attachment;
	
	@FindBy(id="startTime")
	public WebElement startTime;
	
	@FindBy(id="endTime")
	public WebElement endTime;
	
	@FindBy(id="sendForm")
	public WebElement sendFormBtn;
	
	@FindBy(id="success")
	public WebElement success;
	
	
	public TuitionMain(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}

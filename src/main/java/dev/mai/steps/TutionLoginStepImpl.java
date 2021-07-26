package dev.mai.steps;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dev.mai.pages.TuitionMain;
import dev.mai.runner.TuitionRunner;

public class TutionLoginStepImpl {
	
	public static WebDriver driver = TuitionRunner.driver;
	public static TuitionMain tuitionMain = TuitionRunner.tuitionMain;
	
	@Given("^The guest is on the login page$")
	public void the_guest_is_on_the_login_page()  {
	    // Write code here that turns the phrase above into concrete actions
		String url = "file:///Users/caomai/dev/Revature/Projects/TuitionReimbursement/frontend/Login.html";
		driver.get(url);

	}

	@When("^The enters username and password$")
	public void the_enters_username_and_password(){
	    // Write code here that turns the phrase above into concrete actions
		tuitionMain.username.sendKeys("user4");
		tuitionMain.password.sendKeys("pass");
		
		tuitionMain.loginBtn.click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("^They should be logged in$")
	public void they_should_be_logged_in() {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals("Start Request", tuitionMain.request.getText());
		

	}

}

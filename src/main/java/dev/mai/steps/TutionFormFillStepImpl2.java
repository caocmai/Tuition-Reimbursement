package dev.mai.steps;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dev.mai.pages.TuitionMain;
import dev.mai.runner.TuitionRunner;

public class TutionFormFillStepImpl2 {
	
	public static WebDriver driver = TuitionRunner.driver;
	public static TuitionMain tuitionMain = TuitionRunner.tuitionMain;
	
	@Given("^The guest is on the form page now$")
	public void the_guest_is_on_the_form_page_now() {
	    // Write code here that turns the phrase above into concrete actions
		String url = "file:///Users/caomai/dev/Revature/Projects/TuitionReimbursement/frontend/AddForm.html";
		driver.get(url);
		
		

	}

	@When("^The guest fills out the form with their username and password now$")
	public void the_guest_fills_out_the_form_with_their_username_and_password_now() {
	    // Write code here that turns the phrase above into concrete actions
	}

	@Then("^They should now be logged in now$")
	public void they_should_now_be_logged_in_now(){
	    // Write code here that turns the phrase above into concrete actions
	}
}

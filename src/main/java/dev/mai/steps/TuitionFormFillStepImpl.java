package dev.mai.steps;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dev.mai.pages.TuitionMain;
import dev.mai.runner.TuitionRunner;

public class TuitionFormFillStepImpl {
	
	public static WebDriver driver = TuitionRunner.driver;
	public static TuitionMain tuitionMain = TuitionRunner.tuitionMain;
	
	@Given("^The guest is on the form page$")
	public void the_guest_is_on_the_form_page()  {
	    // Write code here that turns the phrase above into concrete actions
		String url = "file:///Users/caomai/dev/Revature/Projects/TuitionReimbursement/frontend/AddForm.html";
		driver.get(url);
		
	}


	@When("^The guest fills out the form with their username and password$")
	public void the_guest_fills_out_the_form_with_their_username_and_password() {
	    // Write code here that turns the phrase above into concrete actions
		tuitionMain.location.sendKeys("Jackson");
		tuitionMain.description.sendKeys("Learning AWS");
		tuitionMain.cost.sendKeys("50");
		Select objSelect  = new Select(tuitionMain.eventType);
		objSelect.selectByValue("Certification");
		
		Select objSelect2  = new Select(tuitionMain.gradingType);
		objSelect2.selectByValue("Grade");
		
		tuitionMain.attachment.sendKeys("None");
		
		
		tuitionMain.startTime.sendKeys("08/03/2021");
		tuitionMain.endTime.sendKeys("08/06/2021");
		
		tuitionMain.sendFormBtn.click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	@Then("^They should now be logged in$")
	public void they_should_now_be_logged_in(){
	    // Write code here that turns the phrase above into concrete actions
		String success = "A Request was successfuly Added";
		assertEquals(success, tuitionMain.success.getText());
		
	}

}

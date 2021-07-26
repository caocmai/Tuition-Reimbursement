package dev.mai.runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import dev.mai.pages.TuitionMain;

@RunWith(Cucumber.class)
@CucumberOptions(features ="src/test/resources", glue="dev.mai.steps")
public class TuitionRunner {
	
	public static WebDriver driver;
	public static TuitionMain tuitionMain;
	
	@BeforeClass
	public static void setUp() {
//		String path = "";
//		System.setProperties("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		tuitionMain = new TuitionMain(driver);
	
	}
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
}


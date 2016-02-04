package br.edu.ifrs.canoas.lds;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.util.Assert;

import br.edu.ifrs.canoas.lds.selenium.HomePage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginDefs extends AbstractDefs {
	private WebDriver driver = new FirefoxDriver();
	private HomePage homePage;

	@Before
	public void setUp() throws Exception {
		homePage = PageFactory.initElements(driver, HomePage.class);
	}

	@Given("^I open google$")
	public void given_I_navigate_to_the_mock_application() {
		//Set implicit wait of 10 seconds and launch the app 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		driver.get(homePage.getTitle());
	}

	@When("^I enter \"([^\"]*)\" in search textbox$")
	public void I_enter_in_search_textbox(String additionTerms) { 
		//Write term in google textbox 
		WebElement googleTextBox = driver.findElement(By.id("lst-ib")); 
		googleTextBox.sendKeys(additionTerms); 
		googleTextBox.submit();
		//Click on searchButton 
	}

	@Then("^I should get result as \"([^\"]*)\"$") 
	public void I_should_get_correct_result(String expectedResult) { 
		//Get result from calculator 
		WebElement calculatorTextBox = driver.findElement(By.id("cwos")); 
		String result = calculatorTextBox.getText(); 
		
		//Verify that result of 2+2 is 4 
		Assert.isTrue(result.equals(expectedResult)); 
		driver.close(); 
	}
	
	@After 
	public void closeBrowser() { 
		driver.quit(); 
	}
}

/**
 * @author:
 * @date: 
 * @description: 
 */
package br.edu.ifrs.canoas.lds.ifskills.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

// TODO: Auto-generated Javadoc
public class HomePage {

    @FindBy(xpath = "//table//td/p/a")
    private List<WebElement> actuatorLinks;

    private final WebDriver driver;

    /**
	 * Instantiates a new home page.
	 *
	 * @param driver
	 *            the driver
	 */
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
	 * Assert that.
	 *
	 * @return the home page assert
	 */
    public HomePageAssert assertThat() {
        return new HomePageAssert(this);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public List<WebElement> getActuatorLinks() {
        return actuatorLinks;
    }
}

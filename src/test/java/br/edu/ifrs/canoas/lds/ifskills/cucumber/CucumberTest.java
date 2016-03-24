/*
 * 
 */
package br.edu.ifrs.canoas.lds.ifskills.cucumber;

import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;

import br.edu.ifrs.canoas.lds.ifskills.IFSkillsApplication;
import br.edu.ifrs.canoas.lds.ifskills.selenium.support.SeleniumTest;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources")

@SpringApplicationConfiguration(IFSkillsApplication.class)
@WebIntegrationTest(value = "server.port=9000")
@SeleniumTest(baseUrl = "http://localhost:9000")
public class CucumberTest{
}

/**
 * @author:
 * @date: 
 * @description: 
 */
package br.edu.ifrs.canoas.lds.ifskills.cucumber;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.http.HttpStatus;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

// TODO: Auto-generated Javadoc
public class StepDefs extends AbstractDefs
{
    
    /**
	 * The_client_issues_ ge t_version.
	 *
	 * @throws Throwable
	 *             the throwable
	 */
    @When("^the client calls /version$")
    public void the_client_issues_GET_version() throws Throwable
    {
        executeGet("http://localhost:8080/version");
    }

    /**
	 * The_client_receives_status_code_of.
	 *
	 * @param statusCode
	 *            the status code
	 * @throws Throwable
	 *             the throwable
	 */
    @Then("^the client receives status code of (\\d+)$")
    public void the_client_receives_status_code_of(int statusCode) throws Throwable
    {
        final HttpStatus currentStatusCode = latestResponse.getTheResponse().getStatusCode();
        assertThat("status code is incorrect : "+ latestResponse.getBody(), currentStatusCode.value(), is(statusCode) );
    }

    /**
	 * The_client_receives_server_version_body.
	 *
	 * @param version
	 *            the version
	 * @throws Throwable
	 *             the throwable
	 */
    @And("^the client receives server version (.+)$")
    public void the_client_receives_server_version_body(String version) throws Throwable
    {
        assertThat(latestResponse.getBody(), is(version)) ;
    }
}

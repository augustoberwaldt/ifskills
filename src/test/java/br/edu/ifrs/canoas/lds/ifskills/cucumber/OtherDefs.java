/*
 * 
 */
package br.edu.ifrs.canoas.lds.ifskills.cucumber;

import cucumber.api.java.en.When;

/**
 * Created with IntelliJ IDEA.
 * User: jacobs
 * Date: 6/11/15
 * Time: 1:04 PM
 */
public class OtherDefs extends AbstractDefs
{	
    
    /**
	 * The_client_issues_ ge t_version.
	 *
	 * @throws Throwable
	 *             the throwable
	 */
    @When("^the client calls /cucumber$")
    public void the_client_issues_GET_version() throws Throwable
    {
        executeGet("http://localhost:8080/cucumber");
    }

}

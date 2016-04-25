/*
 * 
 */
package br.edu.ifrs.canoas.lds.ifskills.controller;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.edu.ifrs.canoas.lds.ifskills.controller.selenium.ItemControlerSeleniumTest;

@RunWith(Suite.class)
@SuiteClasses({ ItemControllerTest.class
	, HomeControllerTest.class
	, ArticleControllerTest.class
	, CommentControllerTest.class
	, JobAdControllerTest.class
	, ItemControlerSeleniumTest.class})
public class AllTests {

}

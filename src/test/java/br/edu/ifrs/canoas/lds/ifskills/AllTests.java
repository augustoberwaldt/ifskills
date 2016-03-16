package br.edu.ifrs.canoas.lds.ifskills;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	br.edu.ifrs.canoas.lds.ifskills.controller.AllTests.class
	, br.edu.ifrs.canoas.lds.ifskills.repository.AllTests.class
	, br.edu.ifrs.canoas.lds.ifskills.service.AllTests.class
	})
public class AllTests {

}

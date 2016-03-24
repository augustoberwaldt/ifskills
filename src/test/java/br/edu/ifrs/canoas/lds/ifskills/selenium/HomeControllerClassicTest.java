/*
 * 
 */
package br.edu.ifrs.canoas.lds.ifskills.selenium;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import br.edu.ifrs.canoas.lds.ifskills.IFSkillsApplication;

// TODO: Auto-generated Javadoc
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = IFSkillsApplication.class)
@WebAppConfiguration
public class HomeControllerClassicTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    /**
	 * Sets the up.
	 *
	 * @throws Exception
	 *             the exception
	 */
    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    /**
	 * Verifies home page loads.
	 *
	 * @throws Exception
	 *             the exception
	 */
    @Test
    public void verifiesHomePageLoads() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
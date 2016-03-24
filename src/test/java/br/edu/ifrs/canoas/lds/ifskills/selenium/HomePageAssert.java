/**
 * @author:
 * @date: 
 * @description: 
 */
package br.edu.ifrs.canoas.lds.ifskills.selenium;

import org.assertj.core.api.AbstractAssert;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

// TODO: Auto-generated Javadoc
public class HomePageAssert extends AbstractAssert<HomePageAssert, HomePage> {

    protected HomePageAssert(HomePage homePage) {
        super(homePage, HomePageAssert.class);
    }

    /**
	 * Checks for actuator link.
	 *
	 * @param values
	 *            the values
	 * @return the home page assert
	 */
    public HomePageAssert hasActuatorLink(String... values) {
        assertThat(getLinkNames()).contains(values);
        return this;
    }

    /**
	 * Checks for no actuator link.
	 *
	 * @param values
	 *            the values
	 * @return the home page assert
	 */
    public HomePageAssert hasNoActuatorLink(String... values) {
        assertThat(getLinkNames()).doesNotContain(values);
        return this;
    }

    private List<String> getLinkNames() {
        List<WebElement> actuatorLinks = actual.getActuatorLinks();
        return actuatorLinks.stream()
                .map(e -> e.getText()).collect(Collectors.toList());
    }
}

/*
 * 
 */
package br.edu.ifrs.canoas.lds.ifskills.selenium.support;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CaseFormatTest {
    
    /**
	 * Converts camel case to lower underscore.
	 */
    @Test
    public void convertsCamelCaseToLowerUnderscore() {
        assertThat(CaseFormat.toLowerUnderscore("HomeControllerTest"))
                .isEqualTo("home_controller_test");
    }
}
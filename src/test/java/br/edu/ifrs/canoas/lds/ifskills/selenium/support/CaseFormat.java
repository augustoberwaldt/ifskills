/**
 * @author:
 * @date: 
 * @description: 
 */
package br.edu.ifrs.canoas.lds.ifskills.selenium.support;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class CaseFormat {

    /**
	 * To lower underscore.
	 *
	 * @param upperCamel
	 *            the upper camel
	 * @return the string
	 */
    public static String toLowerUnderscore(String upperCamel) {
        return Stream
                .of(upperCamel.split("(?=[A-Z])"))
                .map(s -> s.toLowerCase())
                .collect(Collectors.joining("_"));
    }
}

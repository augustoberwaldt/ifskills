/*
 * 
 */
package br.edu.ifrs.canoas.lds.ifskills.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userService;

	/**
	 * Método usado para configurar os usuários.
	 *
	 * @param auth
	 *            the auth
	 * @throws Exception
	 *             the exception
	 */
	@Autowired
	public void configureAuth(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(
				"/webjars/**", 
				"/resources/**",
				"/public/**", 
				"/img/**", 
				"/db/**", 
				"/test/**", 
				"/",
				"/article/view");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/view").permitAll()
			.antMatchers("/cucumber").permitAll()
			.antMatchers("/admin/**").hasRole("ADMIN").anyRequest().authenticated()
			.and().formLogin().loginPage("/login").permitAll()
			.and().logout().deleteCookies("remember-me")
			.logoutSuccessUrl("/login?logout").permitAll().and().rememberMe();
	}

}

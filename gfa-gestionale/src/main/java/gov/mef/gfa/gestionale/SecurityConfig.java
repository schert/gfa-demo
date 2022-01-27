package gov.mef.gfa.gestionale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@EnableConfigurationProperties(ApplicationUsers.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private ApplicationUsers applicationUsers;

	@Override
	protected void configure(HttpSecurity http) {
		try {
			http.csrf().disable();
			http
				.userDetailsService(userDetailsService())
				.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/**.jsf").permitAll()
				.antMatchers("/javax.faces.resource/**").permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.loginPage("/login.jsf")
				.permitAll()
				.failureUrl("/login.jsf?error=true")
				.defaultSuccessUrl("/home.jsf")
				.and()
				.logout()
				.logoutSuccessUrl("/login.jsf")
				.deleteCookies("JSESSIONID");
		}
		catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	protected UserDetailsService userDetailsService() {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		InMemoryUserDetailsManager result = new InMemoryUserDetailsManager();
		for (UserCredentials userCredentials : this.applicationUsers.getUsersCredentials()) {
			result.createUser(User.builder()
				.username(userCredentials.getUsername())
				.password(encoder.encode(userCredentials.getPassword()))
				.authorities(userCredentials.getAuthorities().toArray(new String[0])).build());
		}
		return result;
	}
}

package jpdr.apps.bankdemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class BankDemoSecurityConfig {

	@Bean
	public UserDetailsService userDetailsService() {
		return new BankDemoUserDetailsService();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// http.authenticationProvider(authenticationProvider());
		http.authorizeRequests() // .
				// .antMatchers("/login", "/loginError").permitAll()
				// http.authorizeRequests().antMatchers("/app").authenticated();
				// .antMatchers("/members/**","/members/home").hasAuthority("CAPO").anyRequest().authenticated()
				.antMatchers(
						"/resources/**",
						"/login",
						//"/loginBegin",
						//"/login/loginBegin",
						"/login/registerBegin",
						"/registerResult",
						"/login/registerResult",
						"/register",						
						"/include/**",
						"/error",						
						"/error/error")
					.permitAll()				
				.anyRequest()
					.authenticated()
					.and()
				.formLogin()
					.loginPage("/login")
					.defaultSuccessUrl("/home",true) //allways redirect here (instead of the last url you tried before login)
					.permitAll()
					.and()
				.logout()
					.invalidateHttpSession(true)
					.deleteCookies("JSESSIONID")
					.permitAll();
		// http.headers().frameOptions().sameOrigin();

		return http.build();
	}

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().antMatchers("/resources/**", "/static/**");
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(userDetailsService());
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		return daoAuthenticationProvider;
	}
	   
}
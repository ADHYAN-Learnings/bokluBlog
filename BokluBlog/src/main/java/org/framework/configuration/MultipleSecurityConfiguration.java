/**
 * 
 */
package org.framework.configuration;


import org.framework.security.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Aditya
 *
 */
@Configuration
@EnableWebSecurity
public class MultipleSecurityConfiguration {
	
	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(12);
	}
	
	
	
	@Configuration
	@Order(1)
	public static class AdminSecurity extends WebSecurityConfigurerAdapter {
	
		
		@Autowired
		private  CustomUserDetailsService userDetailsService;
				 
		@Override
		protected void configure(HttpSecurity http) throws Exception {
				
			http.antMatcher("/admin/**")
			    .authorizeRequests()
			    .anyRequest().hasRole("ADMIN")
			    
			    .and()
			    .formLogin()
			    .loginPage("/admin").permitAll()
			    .loginProcessingUrl("/admin")
			    .defaultSuccessUrl("/admin/dashboard")
			    .failureUrl("/admin?error=true")
			    
			    .and()
			    .logout().permitAll()
			    .logoutUrl("/admin/logout").invalidateHttpSession(true).deleteCookies("JSESSIONID")
			    
			    .and()
			    .csrf().disable();
		}
		
		public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
			 final DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
			  authenticationProvider.setPasswordEncoder(passwordEncoder());
			  authenticationProvider.setUserDetailsService(userDetailsService);
			  auth.authenticationProvider(authenticationProvider);
		}
	}
	
	@Configuration
	@Order(2)
	public static class UserSecurity extends WebSecurityConfigurerAdapter {
		
		@Autowired
		private  CustomUserDetailsService userDetailsService;
	
		@Override
        protected void configure(HttpSecurity http) throws Exception  {
	
			
		    http.antMatcher("/boklu/**") 
			    .authorizeRequests()
			    .antMatchers("/boklu","/boklu/signup","/boklu/register","/boklu/registrationConfirmation",
			    		"/boklu/forgotPassword","/boklu/passwordReset",
			    		"/boklu/resetChangePassword","/boklu/savePasswordReset",
			    		"/boklu/saveComment","/boklu/**").permitAll()
			    .anyRequest().hasRole("USER")
			 
			    .and()
			    .formLogin()
			    .loginPage("/boklu/userLogin").permitAll()
			    .loginProcessingUrl("/boklu")
			    .defaultSuccessUrl("/boklu/landingPage")
			    .failureUrl("/boklu/userLogin?error=true")
			    
			    .and()
			    .logout().permitAll()
			    .logoutUrl("/boklu/logout").invalidateHttpSession(true).deleteCookies("JSESSIONID")
			    
			    .and()
			    .csrf().disable();
			   
			
		}
		@Autowired
		public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		
		  final DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		  authenticationProvider.setPasswordEncoder(passwordEncoder());
		  authenticationProvider.setUserDetailsService(userDetailsService);
		  auth.authenticationProvider(authenticationProvider);
		}
		
	}
	
	}

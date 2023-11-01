package com.example.mcqgroupbe.config;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.example.mcqgroupbe.entity.User;

@Configuration
@EnableGlobalMethodSecurity(
		  prePostEnabled = true, 
		  securedEnabled = true, 
		  jsr250Enabled = true)
public class ApplicationConfig  {
	@Bean 
	   public PasswordEncoder passwordEncoder() { 
	      return new BCryptPasswordEncoder(); 
	   } 
//	   @Override 
//	   protected void configure(HttpSecurity http) throws Exception { 
//	      http 
//	      .csrf().disable()
//	      .authorizeRequests().requestMatchers("/register**")
//	      .permitAll() .anyRequest().authenticated() 
//	      .and() 
//	      .formLogin() .loginPage("/login")
//	      .permitAll() 
//	      .and() 
//	      .logout() .invalidateHttpSession(true) 
//	      .clearAuthentication(true) .permitAll(); 
//	   }
//	   
	   @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		   http 
		      .csrf().disable()
		      .authorizeRequests().requestMatchers("/register**","/login")
		      .permitAll() .anyRequest().authenticated() 
		      .and() 
		      .cors()
		      .and()	
		      .formLogin() 
		      .permitAll() 
		      .and() 
		      .logout() .invalidateHttpSession(true) 
		      .clearAuthentication(true) .permitAll()
		      .and().httpBasic(); 
	        return http.build();
	    }
}

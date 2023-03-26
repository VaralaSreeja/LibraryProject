package com.java.springboot.staff.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;


import com.java.springboot.staff.service.impl.StaffServiceimpl;

import io.jsonwebtoken.Claims;


@Configuration
@EnableWebSecurity

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
    private ClassService cService;
	
	@Autowired
	private JwtStaffFilter jwtStaffFilter;
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(cService);
    }
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
		
	}
	
	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		
		return super.authenticationManagerBean();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues())
		    .and()
		    .csrf().disable()
		    .authorizeRequests()
		    .antMatchers("/staff/login","/staff/signup")
		    .permitAll().anyRequest()
		    .authenticated()
		    .and().exceptionHandling()
		    .and().sessionManagement()
		    .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.addFilterBefore(jwtStaffFilter,UsernamePasswordAuthenticationFilter.class );
		
		
	}

}

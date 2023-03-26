package com.java.springboot.staff.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


import com.java.springboot.staff.service.impl.StaffServiceimpl;

import io.jsonwebtoken.Claims;

@Component

public class JwtStaffFilter extends OncePerRequestFilter{
	
	@Autowired
	private JwtStaffUtil jwtStaffUtil;
	
	@Autowired
	private ClassService cService;
	
	Claims claims = null;
	private String userName = null;
	

	@Override
	protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain)
			throws ServletException, IOException {

		if(httpServletRequest.getServletPath().matches("/staff/login|/staff/signup")) {
			
			filterChain.doFilter(httpServletRequest, httpServletResponse);
			
		} else {
			
			String authorizationHeader = httpServletRequest.getHeader("Authorization");
			String token = null;
			
			if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
				token = authorizationHeader.substring(7);
				
				userName = jwtStaffUtil.extractUserName(token);
				claims = jwtStaffUtil.extractAllClaims(token);
			}
			
			if(userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				
				UserDetails staffDet = cService.loadUserByUsername(userName);
				
				if(jwtStaffUtil.validateToken(token, staffDet)) {
					
					UsernamePasswordAuthenticationToken upat = new 
							UsernamePasswordAuthenticationToken(staffDet, null, staffDet.getAuthorities());
					
					upat.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
					
					SecurityContextHolder.getContext().setAuthentication(upat);
				}
				
			}
			
			filterChain.doFilter(httpServletRequest, httpServletResponse);
			
		}
		
	}

}

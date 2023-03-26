package com.java.springboot.Reader.jwt;

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

import io.jsonwebtoken.Claims;

@Component

public class JwtFilter extends OncePerRequestFilter{
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private ClassService cService;
	
	Claims claims = null;
	private String userName = null;

	@Override
	protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain)
			throws ServletException, IOException {
		
		if(httpServletRequest.getServletPath().matches("/user/login|/user/signup")) {
			
			filterChain.doFilter(httpServletRequest, httpServletResponse);
			
		} else {
			
			String authorizationHeader = httpServletRequest.getHeader("Authorization");
			String token = null;
			
			if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
				token = authorizationHeader.substring(7);
				
				userName = jwtUtil.extractUserName(token);
				claims = jwtUtil.extractAllClaims(token);
			}
			
			if(userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				
				UserDetails userDet = cService.loadUserByUsername(userName);
				
				if(jwtUtil.validateToken(token, userDet)) {
					
					UsernamePasswordAuthenticationToken upat = new 
							UsernamePasswordAuthenticationToken(userDet, null, userDet.getAuthorities());
					
					upat.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
					
					SecurityContextHolder.getContext().setAuthentication(upat);
				}
				
			}
			
			filterChain.doFilter(httpServletRequest, httpServletResponse);
			
		}
		
	}
	

}

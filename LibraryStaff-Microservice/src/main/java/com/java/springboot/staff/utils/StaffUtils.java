package com.java.springboot.staff.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class StaffUtils {
	

	private StaffUtils() {
		
	}
	
	public static ResponseEntity<String> getResponseEntity(String responseMessage, HttpStatus httpStatus){
		
		return new ResponseEntity<String>("{\"message\":\""+responseMessage+"\"}", httpStatus);
	}


}

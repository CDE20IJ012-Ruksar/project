package com.cognizant.dailyshare.exception;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import com.cognizant.dailyshare.exception.ExceptionResponse;

class ExceptionResponseTest {
	
	ExceptionResponse exceptionResponse=new ExceptionResponse();

	@Test
	void testExceptionResponseDateStringString() {
		final ExceptionResponse exceptionResponse=new ExceptionResponse(new  Date("21/3/2021"), "error", "error occured");
			
	}

	@Test
	void testGetTimeStamp() {
		exceptionResponse.setTimeStamp(new Date(2021, 3, 21));
		assertEquals(new Date(2021, 3, 21),exceptionResponse.getTimeStamp());
	}

	@Test
	void testExceptionResponse() {
		final ExceptionResponse ex=new ExceptionResponse();
	}

	@Test
	void testGetDetails() {
		exceptionResponse.setDetails("Error");
		assertEquals("Error",exceptionResponse.getDetails());
	}

	@Test
	void testGetMessage() {
		exceptionResponse.setMessage("Error occured");
		assertEquals("Error occured",exceptionResponse.getMessage());
	}

	@Test
	void testToString() {
		assertEquals("ExceptionResponse [timeStamp=null, details=null, message=null]",exceptionResponse.toString());
	}

}

package com.cognizant.calculateNetworth.model;

import lombok.Data;

/**
 * 
 * This is a model class for authenticated response 
 * @author POD-4
 *
 */
@Data
public class AuthResponse {

	private String uid;

	private String name;

	private boolean isValid;

	

}

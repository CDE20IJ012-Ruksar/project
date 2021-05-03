package com.cognizant.dailyshare.model;
/**
 * 
 * This is a model class for authenticating response 
 * @author Ruksar, Revathi, Rameswara, Prachi
 *
 */
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AuthResponse {

	private String uid;

	private String name;

	private boolean isValid;

}
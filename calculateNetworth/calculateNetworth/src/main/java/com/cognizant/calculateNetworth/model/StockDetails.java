package com.cognizant.calculateNetworth.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author POD-4
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockDetails {
	
	private String shareId;

	private String shareName;

	private double shareValue;

}

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
public class MutualFundDetails {

	private String mutualFundId;
	private String mutualFundName;
	private double mutualFundValue;

}

package com.cognizant.calculateNetworth.model;

import java.util.Map;

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
public class SellObjectMap {

	int pid;

	Map<String, Integer> stockIdList;

	Map<String, Integer> mfAssetList;

}

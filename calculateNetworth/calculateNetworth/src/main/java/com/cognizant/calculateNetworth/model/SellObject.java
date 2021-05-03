package com.cognizant.calculateNetworth.model;

import java.util.List;

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
public class SellObject {

	int pid;

	List<String> stockIdList;

	List<String> mfAssetList;

}

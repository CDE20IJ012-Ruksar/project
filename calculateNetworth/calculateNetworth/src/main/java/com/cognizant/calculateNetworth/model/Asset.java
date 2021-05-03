package com.cognizant.calculateNetworth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Model class for Asset
 * @author 895218
 *
 */
@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Asset {
	
	@Id
	@Column
	private int tid;
	
	
	@Column
	private String assetid;
	@Column
	private int portfolioid;
	@Column
	private String type;
	@Column
	private int units;
	
	
}

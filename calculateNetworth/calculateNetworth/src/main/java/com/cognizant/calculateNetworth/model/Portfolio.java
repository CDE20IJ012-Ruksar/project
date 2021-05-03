package com.cognizant.calculateNetworth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This is the model class for Portfolio
 * @author POD-4
 *
 */
@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Portfolio {
	@Id
	@Column
	private int portfolioId;

}
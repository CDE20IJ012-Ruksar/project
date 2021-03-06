package com.cognizant.dailyshare.model;

/**
 * This is a model class for share details
 * @author Ruksar, Revathi, Rameswara, Prachi
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table
public class ShareDetails {
	@Id
	@Column
	private String shareId;
	@Column(name="share_name")
	private String shareName;
	@Column
	private double shareValue;
}
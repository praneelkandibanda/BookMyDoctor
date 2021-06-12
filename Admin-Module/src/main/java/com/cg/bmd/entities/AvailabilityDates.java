package com.cg.bmd.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "availability_dates_table")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvailabilityDates {

	
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private int availibilityId;
	 @OneToOne(cascade=CascadeType.MERGE)
	 private Doctor doctor;
	 
	 private Date enddate;

	 private Date fromdate;
	 

}

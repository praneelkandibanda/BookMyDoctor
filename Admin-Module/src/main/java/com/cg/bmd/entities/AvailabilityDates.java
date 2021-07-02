package com.cg.bmd.entities;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	 @JoinColumn(name = "avail_dates" , referencedColumnName = "doctorId")
	 private Doctor doctor;
	 //private List<Doctor> doctors;
	// @JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "yyyy-mm-dd")
	 //private LocalDate fromDate = LocalDate.now();
	 
	 @Column(name = "fromDate")
	 private Date fromDate;
	 
	 @Column(name = "endDate")
	 private Date endDate;
	 
	 
	 

	// @JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "yyyy-mm-dd")

	 //private LocalDate endDate = LocalDate.now();

	 

}

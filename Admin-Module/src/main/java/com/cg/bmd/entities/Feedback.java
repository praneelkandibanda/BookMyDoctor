package com.cg.bmd.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "feedback_table")
@Data
@NoArgsConstructor
public class Feedback {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int feedbackId;
	
	@Column(name = "rating")
	//@Pattern(regexp = "[1-5]{1}" , message = "Provide Rating from 1 to 5 !!!")
	private int rating;
	
	private String feedbackComment;
	
	@OneToOne(cascade = CascadeType.MERGE )
	@JoinColumn(name = "fp_fk" )
	private Patient patient;
	
	

	

}

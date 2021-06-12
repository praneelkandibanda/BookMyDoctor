package com.cg.bmd.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "patient_table")

@Data
@NoArgsConstructor
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int patientId;
	
	@Column(name =" patientName")
	private String patientName;
	
	@Column(name = "mobileNo")
	@NotNull
	@Pattern(regexp ="[0-9]{10}", message = " Please enter a valid mobile number!!")
	private String mobileNo;
	
	@Column(name ="email")
	@Email
	private String email;
	
	@Column(name="password")
	@Pattern(regexp = "[a-zA-Z0-9!@#$]{8}", message =" Please enter a valid passwords using special charatcers, numbers and alphabets")
	private String password;
	
	private String bloodGroup;
	private String gender;
	private int age;
	private String address;
	
	
//	@ManyToOne(cascade = CascadeType.MERGE)
//	private Doctor doctor; // entity
	
//	@OneToOne( cascade = CascadeType.MERGE)
//	@JoinColumn(name = "tp_fk" , referencedColumnName = "treatmentId")
//	private Feedback feedback;

}


package com.cg.bmd.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "appointment_table")
@Data
@NoArgsConstructor
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int appointmentId;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "patient_fk")
	private Patient patient;
	
//	@ManyToOne(cascade = CascadeType.MERGE , targetEntity = Doctor.class)
//	@JoinColumn(name = "appoint_fk" , referencedColumnName = "doctorId")
//	private Doctor doctor;

//	private List<Doctor> doctors; // entity



	
	private String remark;
	
	private String appointmentStatus;

}

package com.cg.bmd.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "treatment_details_tbl")
@Data
@NoArgsConstructor

public class Treatment {
	
	@Id
	private int treatmentId;
	
	
	@OneToOne( cascade = CascadeType.MERGE)
	@JoinColumn(name = "tp_fk" , referencedColumnName = "patientId")
	private Patient patient;
	
	private String disease;
	//private Date date;
	private String prescription;
	

}

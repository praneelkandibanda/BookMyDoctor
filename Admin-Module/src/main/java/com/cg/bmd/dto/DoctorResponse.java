package com.cg.bmd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorResponse {
	
	//private String doctorName;
	private int doctorId;
	private String doctorName;
	private String patientName;
	private String speciality;
}

package com.cg.bmd.dto;

import java.time.LocalDate;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentResponse {

	private int doctorId;
	private String doctorName;
	private int appointmentId;
	private String appointmentStatus;
	private Date appointmentDate;

}

package com.cg.bmd.dto;

import com.cg.bmd.entities.Patient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentRequest {

	private Patient patient;
}

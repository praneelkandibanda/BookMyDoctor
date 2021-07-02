package com.cg.bmd.dto;

import com.cg.bmd.entities.Doctor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvaliableDateRequest {

	private Doctor doctor;
}

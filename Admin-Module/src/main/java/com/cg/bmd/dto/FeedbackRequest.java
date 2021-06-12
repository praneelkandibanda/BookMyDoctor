package com.cg.bmd.dto;

import com.cg.bmd.entities.Doctor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor
public class FeedbackRequest {

	private Doctor doctor;
}

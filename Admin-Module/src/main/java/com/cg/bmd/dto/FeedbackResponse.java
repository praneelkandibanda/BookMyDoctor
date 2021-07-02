package com.cg.bmd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackResponse {

	private int doctorId;
	private String DoctorName;
	private int FeedbackId;
	private int rating;
	private String FeedbackComment;
}

package com.cg.bmd.service;

import java.util.List;

import com.cg.bmd.entities.Doctor;
import com.cg.bmd.entities.Feedback;
import com.cg.bmd.exception.FeedbackNotFoundException;

public interface IFeedbackService {
	

	Feedback addFeedback(Feedback fbd);
	
	Feedback updateFeedback(Feedback fbd);

	Feedback getFeedback(int feedbackId) throws FeedbackNotFoundException;
	
	List<Feedback> getAllFeedback();
	
	//public Feedback getDoctorFeedbackByDoctor(Doctor doctor);
	
	//List<Feedback> getAllFeedbacksById(Doctor doc);

	//Doctor getDoctorFeedback(Doctor doc);
	
	//List<Feedback> getAllFeedback(Patient patient)
	


}

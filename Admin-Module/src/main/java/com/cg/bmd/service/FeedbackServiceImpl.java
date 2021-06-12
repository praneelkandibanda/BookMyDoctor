package com.cg.bmd.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bmd.entities.Doctor;
import com.cg.bmd.entities.Feedback;
import com.cg.bmd.exception.FeedbackNotFoundException;
import com.cg.bmd.repository.FeedbackRepository;

@Service
public class FeedbackServiceImpl implements IFeedbackService{
	
	Logger logger = LoggerFactory.getLogger(FeedbackServiceImpl.class);
	
	@Autowired
	private FeedbackRepository feedbackRepository;

	@Override
	public Feedback addFeedback(Feedback fbd) {
		// TODO Auto-generated method stub
		return feedbackRepository.save(fbd) ;
	}
	
	@Override
	public Feedback updateFeedback(Feedback fbd) {
		// TODO Auto-generated method stub
		return feedbackRepository.save(fbd);
	}


	@Override
	public Feedback getFeedback(int feedbackId) throws FeedbackNotFoundException {
		
		Optional<Feedback> feedback = feedbackRepository.findById(feedbackId);
		if(!feedback.isPresent())
			throw new FeedbackNotFoundException();

		return feedback.get();
	}

	@Override
	public List<Feedback> getAllFeedback() {
		
		return feedbackRepository.findAll();
	}
/*
	@Override
	public Feedback getDoctorFeedbackByDoctor(Doctor doctor) {
	}
*/
//	@Override
//	public List<Feedback> getAllFeedbacksById(Doctor doctor) {
//		
//		List<Feedback> feedbacks = new ArrayList<>();
//		feedbackRepository.findDoctorFeedbackByDoctor(doctor).forEach(feedbacks :: add);
//		return feedbacks;
//
//	}
	

//	@Override
//	public Feedback getDoctorFeedbackByDoctor(Doctor doctor) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	

}

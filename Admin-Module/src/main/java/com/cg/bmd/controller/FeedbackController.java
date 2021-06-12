package com.cg.bmd.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bmd.entities.Feedback;
import com.cg.bmd.exception.FeedbackNotFoundException;
import com.cg.bmd.service.IFeedbackService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {
	Logger logger = LoggerFactory.getLogger(FeedbackController.class);
	@Autowired
	private IFeedbackService feedbackService;
	
	@PostMapping("/saveFeedback")
	public ResponseEntity<Feedback> save(@Valid @RequestBody Feedback fbd)
	{
		logger.info(" New Feedback is Added !!!!");
		 Feedback f =feedbackService.addFeedback(fbd);
		return new ResponseEntity<>(f, HttpStatus.CREATED);
		
	}
	
	@PutMapping("/updateFeedback")
	@ApiOperation("update feedback")
	public Feedback updateFeedback(@Valid @RequestBody Feedback fbd) {
		logger.info("Feedback is Updated !!!");	
		return feedbackService.updateFeedback(fbd);
		
	}

    @GetMapping("getfeedbackbyId/{feedbackId}")
    @ApiOperation("getting feedback by Id")
    public Feedback fetchById(@PathVariable int feedbackId) throws FeedbackNotFoundException {
    return feedbackService.getFeedback(feedbackId);
    }
	
    @GetMapping("/fetchAllFeedbacks")
    @ApiOperation("all feedbacks")
    public List<Feedback> fetch() {
    	return feedbackService.getAllFeedback();
    }
	

}

package com.cg.bmd.service;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.bmd.entities.Feedback;
import com.cg.bmd.entities.Patient;
import com.cg.bmd.repository.FeedbackRepository;
import com.cg.bmd.repository.PatientRepository;

@SpringBootTest
public class FeedbackServiceTest {

	
	@Mock
	FeedbackRepository repository = org.mockito.Mockito.mock(FeedbackRepository.class);



	@InjectMocks
	FeedbackServiceImpl feedbackservice;
	
	
	@Mock
	PatientRepository Prepo;
	
	
	@InjectMocks
	PatientServiceImpl Pservice;
	
	@Test
	public void savefeedbackTest()
	{
		 Patient patient = new Patient();
		 patient.setId(1);
		 patient.setAddress("Hyderabad");
		 patient.setAge(22);
		 patient.setBloodGroup("A +ve");
		 Prepo.save(patient);
		 when(Prepo.save(patient)).thenReturn(patient);
		
		 Feedback feedback = new Feedback();
		 feedback.setFeedbackComment("Good");
		 feedback.setRating(5);
		 feedback.setFeedbackId(2);
		 repository.save(feedback);
	     when(repository.save(feedback)).thenReturn(feedback);
		 
	}

	@Test
	public void getfeedbackTest()
	{
		 Patient pt = new Patient();
		pt.setId(1);
		 pt.setAddress("Hyderabad");
		pt.setAge(22);
		pt.setBloodGroup("A +ve");
		 Prepo.save(pt);
		 when(Prepo.save(pt)).thenReturn(pt);
		 
		 Feedback fb = new Feedback();
		 fb.setFeedbackComment("Good");
		 fb.setRating(5);
		 fb.setFeedbackId(2);
		 repository.save(fb);
	     when(repository.save(fb)).thenReturn(fb);
		 
	}

	@Test
	public void findAllfeedBackTest()
	{

		 Patient patient = new Patient();
		 patient.setId(1);
		 patient.setAddress("Hyderabad");
		 patient.setAge(22);
		 patient.setBloodGroup("A +ve");
		 Prepo.save(patient);
		 when(Prepo.save(patient)).thenReturn(patient);
		 
		 Feedback feedback = new Feedback();
		 feedback.setFeedbackComment("Good");
		 feedback.setRating(5);
		 feedback.setFeedbackId(2);
		 repository.save(feedback);
		 

		 Patient patient1 = new Patient();
		 patient1.setId(2);
		 patient1.setAddress("Hyderabad");
		 patient1.setAge(30);
		 patient1.setBloodGroup("B +ve");
		 Prepo.save(patient1);
		 when(Prepo.save(patient1)).thenReturn(patient1);

		 Feedback feedback1 = new Feedback();
		 feedback1.setFeedbackComment("Super");
		 feedback1.setRating(9);
		 feedback1.setFeedbackId(2);
		 repository.save(feedback1);
		 

		 Patient patient2 = new Patient();
		 patient2.setId(3);
		 patient2.setAddress("Chennai");
		 patient2.setAge(54);
		 patient2.setBloodGroup("O +ve");
		 Prepo.save(patient2);
		 when(Prepo.save(patient2)).thenReturn(patient2);
		 
		 Feedback feedback2 = new Feedback();
		 feedback2.setFeedbackComment("Average");
		 feedback2.setRating(3);
		 feedback2.setFeedbackId(3);
		 repository.save(feedback2);

		 List<Feedback> feedbacksList = new ArrayList<>();
		 feedbacksList.add(feedback);
		 feedbacksList.add(feedback1);
		 feedbacksList.add(feedback);
		 
		 when(repository.findAll()).thenReturn(feedbacksList);

		 List<Feedback> fList = feedbackservice.getAllFeedback();

		 assertEquals(fList,feedbacksList);


		 
		 
	}
	
}






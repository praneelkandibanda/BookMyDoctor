package com.cg.bmd.service;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


import com.cg.bmd.entities.Patient;

import com.cg.bmd.repository.PatientRepository;

@SpringBootTest

public class PatientServiceTest {

	 public static Patient patient,patient1,patient2;
	 @BeforeAll
		public static void setUp() {
	     patient = new Patient();
	     patient1 = new Patient();
	     patient2 = new Patient();
	     
	     patient.setId(1);
	     patient.setPassword("Surya@58");
	     patient.setPatientName("surya");
	     patient.setEmail("surya@gmail.com");
	     patient.setMobileNo(705522698);
	     
	     patient1.setPassword("Eneruk@3");
	     patient1.setPatientName("Eneru");
	     patient1.setEmail("eneru@gmail.com");
	     patient1.setMobileNo(1217025211);


	     patient2.setPassword("Sanji@13");
	     patient2.setPatientName("Sanji");
	     patient2.setEmail("sanji@gmail.com");
	     patient2.setMobileNo(1224436587);
	     
		}
		
		@Autowired
	 IPatientService patientService;


	 @MockBean
	 PatientRepository patientRepository;


	 @Test
	 @DisplayName("positive test case of add patient")
	 void testAddPatientValidTest() throws Exception{
	     when(patientRepository.save(patient)).thenReturn(patient);
	     assertEquals(patient, patientService.addPatient(patient));

	 }
	 
	 @Test
	 @DisplayName("negative test case of add patient")
	 void testAddPatientNotValidTest() throws Exception{
	     when(patientRepository.save(patient)).thenReturn(patient);
	     assertNotEquals(patient1, patientService.addPatient(patient));

	 }

	 @Test
	 @DisplayName("positive test case for get patient")
	 void testGetPatientPositive() throws Exception{
	     when(patientRepository.findById(1)).thenReturn(Optional.of(patient1));
	     patient = patientService.fetchPatientById(1);
	     assertEquals(patient1.toString(), patient.toString());	
	 }

	 @Test
	 @DisplayName("negative test case for get patient")
	 void testGetPatientNegative() throws Exception{
	     when(patientRepository.findById(2)).thenReturn(Optional.of(patient1));
	     patient = patientService.fetchPatientById(2);
	     assertNotEquals(patient2.toString(), patient.toString());

	 }

	 @Test
	 @DisplayName("positive test case of get all patient")
	 void testGetAllpatientive() throws Exception{
	     List<Patient> list = new ArrayList<>();
	     list.add(patient1);
	     list.add(patient2);
	     patientService.getAllPatient();
	     when(patientRepository.findAll()).thenReturn(list);
	     assertEquals(list.size(), patientService.getAllPatient().size());

	 }

	 @Test
	 @DisplayName("negative test case of get all patient")
	 void testGetAllpatientNegative() throws Exception{
	     List<Patient> list = new ArrayList<>();
	     list.add(patient1);
	     list.add(patient2);
	     patientService.getAllPatient();
	     when(patientRepository.findAll()).thenReturn(list);
	     assertNotEquals(3, patientService.getAllPatient().size());

	 }


}

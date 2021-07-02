package com.cg.bmd.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.cg.bmd.entities.Doctor;
import com.cg.bmd.repository.DoctorRepository;

@SpringBootTest
public class DoctorServiceTest {

	@Autowired
	IDoctorService doctorService;
	
	@MockBean
	DoctorRepository doctorRepository;


	public static Doctor doctor, doctor1, doctor2;
	
	@BeforeEach // It is used to signal that the annotated method shuld be executed befor each 
	             // @Test method in the current class.
	
	public void setup() {
		doctor = new Doctor();
		doctor.setDoctorId(1);
		doctor.setPassword("nihal@123");
		doctor.setDoctorName("Nihal");
		doctor.setEmail("nihal@gmail.com");
		doctor.setLocation("Mumbai");
		doctor.setSpeciality("general");
		doctor.setHospitalName("kims");
		doctor.setMobileNo(860003339);
		doctor.setChargedPerVisit(500.00);

		doctor = new Doctor();
		doctor.setDoctorId(2);
		doctor.setPassword("nihal@123");
		doctor.setDoctorName("Sh@43jhb");
		doctor.setEmail("nihal@gmail.com");
		doctor.setLocation("Mumbai");
		doctor.setSpeciality("general");
		doctor.setHospitalName("kims");
		doctor.setMobileNo(860003339);
		doctor.setChargedPerVisit(500.00);
		
	}
	
	@Test
	@DisplayName("Test case for addDoctor valid")	void testAddDoctorPositive() {		
		when(doctorRepository.save(doctor)).thenReturn(doctor);
		assertEquals(doctor, doctorService.addDoctor(doctor));
	}

	@Test
	@DisplayName("Test for case addDoctor invalid")
	void testAddDoctorNegative() {
		when(doctorRepository.save(doctor)).thenReturn(doctor);
		assertNotEquals(doctor1, doctorService.addDoctor(doctor));
	}
	
	@Test
	@DisplayName("Test case to getDoctor with correct id")
	void testGetDoctorPositive() throws Exception {
		when(doctorRepository.findById(1)).thenReturn(Optional.of(doctor));
		assertEquals(doctor, doctorService.getDoctor(1));
	}
	
	@Test
	@DisplayName("Test case to getDoctor with wrong id ")
	void testGetDoctorNegative() throws Exception {
		when(doctorRepository.findById(1)).thenReturn(Optional.of(doctor));
		assertNotEquals(doctor1, doctorService.getDoctor(1));
	}
	
	@Test
	@DisplayName("fetch all doctor functionality")
	void fetchAllTest() {
		when(doctorRepository.findAll()).thenReturn(Stream
				.of(new Doctor(),
						new Doctor()).collect(Collectors.toList()));
		assertEquals(2, doctorService.getDoctorList().size());
	}
	
	@Test
	@DisplayName("fetch all doctor speciality")
	void fetchSpecialistTest() {
		when(doctorRepository.findBySpeciality("general")).thenReturn(Stream
				.of(new Doctor(),
						new Doctor()).collect(Collectors.toList()));
		assertEquals(2, doctorService.getBySpeciality("general").size());
	}
	
//	@Test
//	@DisplayName("fetch all doctor speciality")
//	void fetchPatientByDoctorIdTest() {
//		when(doctorRepository.findPatientsByDoctor(doctorId)).thenReturn(doctor);
//		assertEquals(doctor, doctorService.getPatientsByDoctor(doctorId));	}
//	

}
package com.cg.bmd.service;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.bmd.entities.Appointment;
import com.cg.bmd.repository.AppointmentRepository;

@SpringBootTest

public class AppointmentServiceTest {
	
	public static Appointment appointment, appointment1, appointment2;
	
	@BeforeAll
	public static void setUp() {
		appointment = new Appointment();
		appointment1 = new Appointment();
		appointment2 = new Appointment();
        
        appointment.setAppointmentId(1);
       // appointment.setAppointmentDate();
        appointment.setRemark("Nothing");
        appointment.setAppointmentStatus("Requested");
        
        
       // appointment1.setAppointmentId(2);
       // appointment.setAppointmentDate();
        appointment1.setRemark("Good");
        appointment1.setAppointmentStatus("Accepted");
        
        
        //appointment2.setAppointmentId(2);
       // appointment.setAppointmentDate();
        appointment2.setRemark("Best");
        appointment2.setAppointmentStatus("Rejected");
        
        
       
        
	}
	
	@Autowired
    IAppointmentService appointmentService;


    @MockBean
    AppointmentRepository appointmentRepository;


    @Test
    @DisplayName("positive test case of add appointment")
    void testAddAppointmentValidTest() throws Exception{
        when(appointmentRepository.save(appointment)).thenReturn(appointment);
        assertEquals(appointment, appointmentService.addAppointment(appointment));

    }
    
    @Test
    @DisplayName("negative test case of add appointment")
    void testAddAdminNotValidTest() throws Exception{
        when(appointmentRepository.save(appointment)).thenReturn(appointment);
        assertNotEquals(appointment1, appointmentService.addAppointment(appointment));

    }

    @Test
    @DisplayName("positive test case for get appointment")
    void testGetAppointmentPositive() throws Exception{
        when(appointmentRepository.findById(1)).thenReturn(Optional.of(appointment1));
        appointment = appointmentService.getAppointment(1);
        assertEquals(appointment1.toString(), appointment.toString());	
    }

    @Test
    @DisplayName("negative test case for get appointment")
    void testGetAppointmentNegative() throws Exception{
        when(appointmentRepository.findById(2)).thenReturn(Optional.of(appointment1));
        appointment = appointmentService.getAppointment(1);
        assertNotEquals(appointment.toString(), appointment.toString());

    }

    @Test
    @DisplayName("positive test case of get all appointments")
    void testGetAllAppointments() throws Exception{
        List<Appointment> list = new ArrayList<>();
        list.add(appointment1);
        list.add(appointment2);
        appointmentService.fetchAll();
        when(appointmentRepository.findAll()).thenReturn(list);
        assertEquals(list.size(), appointmentService.fetchAll().size());

    }

    @Test
    @DisplayName("negative test case of get all appointments")
    void testGetAllAppointmentsNegative() throws Exception{
    	List<Appointment> list = new ArrayList<>();
        list.add(appointment1);
        list.add(appointment2);
        appointmentService.fetchAll();
        when(appointmentRepository.findAll()).thenReturn(list);
        assertEquals(list.size(), appointmentService.fetchAll().size());

    }
}
	

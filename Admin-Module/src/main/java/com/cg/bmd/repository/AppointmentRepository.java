package com.cg.bmd.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.bmd.entities.Appointment;
import com.cg.bmd.entities.Doctor;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment , Integer>{


//	@Query("SELECT new com.cg.bmd.dto.AppointmentStatusResponse(p.PatientName , a.appointmentStatus) FROM Appointment a JOIN a.patients p")
//
//	public List<AppointmentStatusResponse> getPAJoin();

}

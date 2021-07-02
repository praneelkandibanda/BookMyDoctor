package com.cg.bmd.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//import com.cg.bmd.dto.AppointmentStatusResponse;
import com.cg.bmd.dto.AppointmentResponse;
import com.cg.bmd.dto.DoctorResponse;
import com.cg.bmd.dto.FeedbackResponse;
import com.cg.bmd.dto.PatientResponse;
import com.cg.bmd.entities.Doctor;
import com.cg.bmd.entities.Feedback;
import com.cg.bmd.entities.Patient;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor , Integer> {


	
	public Doctor findByDoctorId(int doctorId);

	 public List<Doctor> findBySpeciality(String speciality);
	 
	 
	 
	
	   @Query("SELECT new com.cg.bmd.dto.AppointmentResponse(d.doctorId,d.doctorName ,a.appointmentId,  a.appointmentStatus, a.appointmentDate)From Doctor d JOIN d.appointments a WHERE doctor_Id = ?1")
	 
	   public List<AppointmentResponse> getAppointmentDetails(int doctorId);
	   
	   @Query("SELECT new com.cg.bmd.dto.FeedbackResponse(d.doctorId , d.doctorName , f.feedbackId,f.rating , f.feedbackComment)From Doctor d JOIN d.feedbacks f WHERE doctor_Id = ?1")
	   public List<FeedbackResponse> getFeedbackDetails(int doctorId);
//		@Query("SELECT new com.cg.bmd.dto.PatientResponse(d.doctorName ,  p.patientName) FROM Doctor d JOIN d.patients p")
//		 
//		 public List<PatientResponse> getDPJoin();

//	   @Query("SELECT new com.cg.bmd.dto.AppointmentDateResponse(d.doctorName , a.appointmentDate) FROM Doctor d JOIN d.appointments a")
//	   public List<AppointmentDateResponse> getJoinDateList();

	   

}

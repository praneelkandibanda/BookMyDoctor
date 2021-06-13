package com.cg.bmd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.bmd.dto.AppointmentResponse;
import com.cg.bmd.dto.DoctorResponse;
import com.cg.bmd.dto.FeedbackResponse;
import com.cg.bmd.dto.PatientResponse;
import com.cg.bmd.entities.Doctor;
import com.cg.bmd.entities.Feedback;
import com.cg.bmd.entities.Patient;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor , Integer> {


	public Doctor findByDoctorName(String doctorName);
	
	public Doctor findByDoctorId(int doctorId);

	


//	@Query("SELECT new com.cg.bmd.dto.PatientResponse(d.doctorName ,  p.patientName) FROM Doctor d JOIN d.patients p")
//	 
//	 public List<PatientResponse> getDPJoin();

	 public List<Doctor> findBySpeciality(String speciality);
	 
//	 @Query("SELECT new com.cg.bmd.dto.PatientResponse(d.doctor , p.patientName) FROM Doctor d JOIN d.patients p")
//	 public List<Patient>  findPatientListByDoctorId(int doctorId);
	

	
	   @Query("SELECT new com.cg.bmd.dto.AppointmentResponse(d.doctorName , a.appointmentStatus)From Doctor d JOIN d.appointments a")
	 
	   public List<AppointmentResponse> getDAJoin();
	 

//	   @Query("SELECT new com.cg.bmd.dto.FeedbackResponse(d.doctorName , f.feedbackComments)FROM Doctor d JOIN d.feedbacks f")
//	   public List<FeedbackResponse> getDFJoin();
	   
//	   public List<Feedback> findByDoctor(int doctorId);

}

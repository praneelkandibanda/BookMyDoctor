package com.cg.bmd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.bmd.dto.AvailableDateResponse;
import com.cg.bmd.entities.AvailabilityDates;

@Repository
public interface AvailabilityRepository  extends JpaRepository<AvailabilityDates,Integer>{
	
//	@Query("SELECT new com.cg.bmd.dto.AvailableDateResponse(d.doctorName , a.fromDate , a.endDate)FROM Doctor d JOIN d.dates a") 
//	List<AvailableDateResponse> getAvaliableDates();
	

}

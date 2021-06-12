package com.cg.bmd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.bmd.entities.Patient;
import com.cg.bmd.entities.Treatment;

@Repository
public interface TreatmentRepository extends JpaRepository<Treatment , Integer> {
	public Treatment getById(int patientId);
}

package com.cg.bmd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.bmd.entities.AvailabilityDates;

@Repository
public interface AvailabilityRepository  extends JpaRepository<AvailabilityDates,Integer>{

}

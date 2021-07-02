package com.cg.bmd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.bmd.entities.Doctor;
import com.cg.bmd.entities.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback , Integer>{


}

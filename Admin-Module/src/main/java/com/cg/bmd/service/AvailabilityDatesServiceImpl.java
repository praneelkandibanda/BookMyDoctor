package com.cg.bmd.service;

import java.time.LocalDate;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.bmd.entities.Appointment;
import com.cg.bmd.entities.AvailabilityDates;
import com.cg.bmd.entities.Doctor;
import com.cg.bmd.repository.AvailabilityRepository;

@Service
public class AvailabilityDatesServiceImpl implements IAvailabilityDatesService {
	
	
	Logger logger = LoggerFactory.getLogger(AvailabilityDatesServiceImpl.class);

	@Autowired
    private AvailabilityRepository aRepository;

	@Transactional 
	@Override

	public AvailabilityDates addAvailability(AvailabilityDates bean) {
		
		 bean.setFromDate(LocalDate.now());
		 
		 bean.setEndDate(LocalDate.now().plusDays(3));
		 
		logger.info("inside AccountserviceImpl add account method"+bean);
		
	return aRepository.save(bean);

	}

	

	@Override

	public AvailabilityDates updateAvailability(AvailabilityDates bean) {
		
		 bean.setFromDate(LocalDate.now());
		 
		 bean.setEndDate(LocalDate.now().plusDays(3));

		
		logger.info("Successfully Updated dates by Doctor !!!");
	return aRepository.save(bean);

	}



	
	
//	@Override
//	@Transactional
//	public Account addAccount(Account account) {
//		logger.info("inside AccountserviceImpl add account method"+account);
//
//		account.setRegisteredDate(LocalDate.now());
//		logger.info("inside AccountserviceImpl add account method"+account);
//
//		return repository.save(account);
//	}
//	
//	@Override
//	
//	public Page<Appointment> getAppointmentsSortedByDate(int doctorId) {
//		Optional<AvailabilityDates> eng = aRepository.findById(doctorId);
//		if (eng.isPresent()) {
//			Pageable pageable = PageRequest.of(0, 10, Direction.ASC, "complaintDate");
//			return aRepository.findAll(pageable);
//			 
//	
//	}
//		throws Exception();
	//}

}

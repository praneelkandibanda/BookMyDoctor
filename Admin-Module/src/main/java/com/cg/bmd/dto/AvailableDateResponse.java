package com.cg.bmd.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvailableDateResponse {

	private String doctorName;
	private Date fromDate;
	private Date endDate;
}

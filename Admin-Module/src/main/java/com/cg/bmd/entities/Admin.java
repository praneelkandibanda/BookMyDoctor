package com.cg.bmd.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data   
@NoArgsConstructor
@Builder
@Entity
@Table(name = "admin_table")
@AllArgsConstructor
public class Admin {

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name =" adminId")

	private int id;
	@Column(name = "adminName")
	@NotNull
	@Size(min = 2, message =" Please enter minimum of 2 characters !!")
	private String adminName;
	
	@Column(name = " contactNumber")
//	@NotNull
//	@Size(min=10 , message = "Please enter valid 10 digits mobile number !!!!")
//	@Pattern(regexp = "[0-9]{10}")
	private long contactNumber;
	
	@Column(name = "email")
	@Email
	private String email;
	
	@Column(name = "password")
	@NotNull
	
	@Pattern(regexp = "[a-zA-Z0-9!@#$]{8}" , message = "Please use atleast 1 caps small letters and special characters !! " )
	private String password;

    @OneToMany(targetEntity = Patient.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "ap_fk", referencedColumnName = "adminId")
    private List<Patient> patients;
    
    @OneToMany(targetEntity = Doctor.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "ad_fk", referencedColumnName = "adminId")
    private List<Doctor> doctors;


	/*
	@OneToMany(mappedBy = "admin"
			,cascade =CascadeType.ALL)
	private List<Doctor> doctors;
	*/
	//@Column(name = "1")
	//private  int role =1;
}

package com.ayush.Hospital_Management_System.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "doctors")
public class Doctor {

	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long doctorId;

	    @Column(nullable = false, length = 100)
	    private String name;

	    @Column(nullable = false, unique = true, length = 100)
	    private String email;

	    @Column(nullable = false, unique = true, length = 15)
	    private String contactNumber;
	    
	    @Column(nullable = false, length = 100)
	    private String password;

	    @Column(nullable = false, length = 50)
	    private String specialization;

	    @Column(nullable = false)
	    private int experienceYears;

	    @Column(nullable = false, length = 255)
	    private String clinicAddress;

	    @Column(nullable = false, length = 50)
	    private String availableDays; // Example: "Monday,Wednesday,Friday"

	    @Column(nullable = false)
	    private double consultationFee;

	    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL,fetch = FetchType.LAZY, orphanRemoval = true)
	    @JsonIgnore 
	    private List<Appointment> appointments;
}

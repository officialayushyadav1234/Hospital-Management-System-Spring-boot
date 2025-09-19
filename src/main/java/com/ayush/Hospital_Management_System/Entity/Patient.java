package com.ayush.Hospital_Management_System.Entity;

import java.time.LocalDate;
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
@Table(name = "patients")
public class Patient {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int patientId;

	    @Column(nullable = false, unique = true, length = 15)
	    private String contactNumber;

	    @Column(nullable = false, unique = true)
	    private String email;

	    @Column(nullable = false)
	    private String password;

	    @Column(nullable = false)
	    private String firstName;

	    private String lastName;

	    @Column(nullable = false)
	    private LocalDate dateOfBirth;

	    @Enumerated(EnumType.STRING)
	    @Column(nullable = false, length = 10)
	    private Gender gender;

	    private String address;

	    private String emergencyContact;

	    @Column(length = 5)
	    private String bloodType;

	    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL,fetch = FetchType.LAZY, orphanRemoval = true)
	    @JsonIgnore
	    private List<Appointment> appointments;

	    public enum Gender {
	        MALE, FEMALE, OTHER
	    }
}

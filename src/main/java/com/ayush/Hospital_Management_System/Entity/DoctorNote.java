package com.ayush.Hospital_Management_System.Entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "doctor_notes")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "noteId")
public class DoctorNote {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long noteId;

	    @ManyToOne
	    @JoinColumn(name = "doctor_id", nullable = false)
	    private Doctor doctor;

	    @ManyToOne
	    @JoinColumn(name = "patient_id", nullable = false)
	    private Patient patient;

	    @Column(nullable = false, columnDefinition = "TEXT")
	    private String noteContent;

	    @Column(nullable = false)
	    private LocalDateTime createdAt = LocalDateTime.now();
}

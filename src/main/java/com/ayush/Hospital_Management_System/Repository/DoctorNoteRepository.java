package com.ayush.Hospital_Management_System.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ayush.Hospital_Management_System.Entity.DoctorNote;
import com.ayush.Hospital_Management_System.Entity.Patient;

public interface DoctorNoteRepository extends JpaRepository<DoctorNote, Long> {

	 // Find all notes for a specific patient
    List<DoctorNote> findByPatient(Patient patient);
}

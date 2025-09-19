package com.ayush.Hospital_Management_System.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ayush.Hospital_Management_System.Entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

    boolean existsByContactNumber(String contactNumber); // Matches String type in Patient entity
    
    boolean existsByEmail(String email); // To check if email exists
    
    Patient findByEmail(String email); // Fetch patient by email
    
    Patient findByContactNumber(String contactNumber); // Fetch patient by contact number
    
    // New method to check if a patient exists with given id and password
    boolean existsByPatientIdAndPassword(int patientId, String password);
}

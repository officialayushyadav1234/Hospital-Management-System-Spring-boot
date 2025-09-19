package com.ayush.Hospital_Management_System.Dao;

import java.util.List;
import java.util.Optional;

import com.ayush.Hospital_Management_System.Entity.Patient;

public interface PatientsDao {

	Patient savePatientDao(Patient patient);
	List<Patient> getAllPatientDao();
	Optional<Patient> getPatientByIdDao(int id);
	Patient findByContactNumberDao(String contactNumber);
	Patient findByEmailDao(String email);
	boolean existsByEmailDao(String email);
	boolean isValidPatient(int patientId, String password);
}

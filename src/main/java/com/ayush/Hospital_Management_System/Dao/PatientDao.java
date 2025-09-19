package com.ayush.Hospital_Management_System.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ayush.Hospital_Management_System.Entity.Patient;
import com.ayush.Hospital_Management_System.Repository.PatientRepository;


@Repository
public class PatientDao implements PatientsDao {
 
	@Autowired
	private PatientRepository repository;

	@Override
	public Patient savePatientDao(Patient patient) {
		return repository.save(patient);
	}

	@Override
	public List<Patient> getAllPatientDao() {
		return repository.findAll();
	}

	@Override
	public Optional<Patient> getPatientByIdDao(int id) {
		return repository.findById(id);
	}

	@Override
	public Patient findByContactNumberDao(String contactNumber) {
		return repository.findByContactNumber(contactNumber);
	}

	@Override
	public Patient findByEmailDao(String email) {
		return repository.findByEmail(email);
	}

	@Override
	public boolean existsByEmailDao(String email) {
		return repository.existsByEmail(email);
	}

	@Override
	public boolean isValidPatient(int patientId, String password) {
		return repository.existsByPatientIdAndPassword(patientId, password);
	}
}
package com.ayush.Hospital_Management_System.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayush.Hospital_Management_System.Dao.PatientsDao;
import com.ayush.Hospital_Management_System.Entity.Patient;


@Service
public class PatientService implements PatientsService {

	@Autowired
	private PatientsDao dao;
	
	@Override
	public Patient savePatient(Patient patient) {
		if (dao.existsByEmailDao(patient.getEmail())) {
			return null;
		}
		return dao.savePatientDao(patient);
	}

	@Override
	public List<Patient> getAllPatient() {
		return dao.getAllPatientDao();
	}

	@Override
	public Optional<Patient> getPatientById(int id) {
		return dao.getPatientByIdDao(id);
	}

	@Override
	public Patient findByContactNumber(String contactNumber) {
		return dao.findByContactNumberDao(contactNumber);
	}

	@Override
	public Patient findByEmail(String email) {
		if (dao.existsByEmailDao(email)) {
			return dao.findByEmailDao(email);	
		}
		return null;
	}

	@Override
	public boolean existsByEmail(String email) {
		return dao.existsByEmailDao(email);
	}

	@Override
	public boolean authenticatePatientCredentials(int patientId, String password) {
		return dao.isValidPatient(patientId, password);
	}	
}

package com.ayush.Hospital_Management_System.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayush.Hospital_Management_System.Dao.DoctorsDao;
import com.ayush.Hospital_Management_System.Entity.Doctor;

@Service
public class DoctorService implements DoctorsService{

	@Autowired
	private DoctorsDao dao;

	@Override
	public Doctor saveDoctor(Doctor doctor) {
		return dao.saveDoctorDao(doctor);
	}

	@Override
	public List<Doctor> getAllDoctor() {
		return dao.getAllDoctorDao();
	}

	@Override
	public Optional<Doctor> getDoctorById(long id) {
		return dao.getDoctorByIdDao(id);
	}

	@Override
	public Doctor findByEmail(String email) {
		if (dao.existsByEmailDao(email)) {
			return dao.findByEmailDao(email);
		}
		return null;
		
	}

	@Override
	public Doctor findByContactNumber(String contactNumber) {
		if (dao.existsByContactNumberDao(contactNumber)) {
			return dao.findByContactNumberDao(contactNumber);
		}
		return null;
		
	}

	@Override
	public List<Doctor> findBySpecialization(String specialization) {
		return dao.findBySpecializationDao(specialization);
	}

	@Override
	public boolean existsByEmail(String email) {
		return dao.existsByEmailDao(email);
	}

	@Override
	public boolean existsByContactNumber(String contactNumber) {
		return dao.existsByContactNumberDao(contactNumber);
	}

	@Override
	public boolean authenticateDoctor(Long doctorId, String password) {
		if (doctorId == null) return false;
		if (password == null) return false;
		return dao.authenticateDoctorDao(doctorId, password);
	}

	@Override
	public boolean deleteDrById(long id) {
		if (id!=0) {
			dao.deleteDoctorById(id);
			return true;
		}
		return false;
	}
}

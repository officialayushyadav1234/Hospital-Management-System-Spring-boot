package com.ayush.Hospital_Management_System.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayush.Hospital_Management_System.Entity.Doctor;
import com.ayush.Hospital_Management_System.Entity.DoctorNote;
import com.ayush.Hospital_Management_System.Entity.Patient;
import com.ayush.Hospital_Management_System.Repository.DoctorNoteRepository;


@Service
public class DoctorNoteService {

	  @Autowired
	    private DoctorNoteRepository doctorNoteRepository;

	    @Autowired
	    private DoctorsService doctorsService;

	    @Autowired
	    private PatientsService patientsService;

	    // Save a doctor's note
	    public DoctorNote saveDoctorNote(DoctorNote doctorNote) {
	        if (doctorNote.getDoctor() == null || doctorNote.getPatient() == null) {
	            throw new IllegalArgumentException("Doctor and Patient information must be provided!");
	        }

	        // Validate Doctor
	        Optional<Doctor> doctorOpt = doctorsService.getDoctorById(doctorNote.getDoctor().getDoctorId());
	        if (doctorOpt.isEmpty()) {
	            throw new RuntimeException("Doctor not found with ID: " + doctorNote.getDoctor().getDoctorId());
	        }
	        doctorNote.setDoctor(doctorOpt.get());

	        // Validate Patient
	        Optional<Patient> patientOpt = patientsService.getPatientById(doctorNote.getPatient().getPatientId());
	        if (patientOpt.isEmpty()) {
	            throw new RuntimeException("Patient not found with ID: " + doctorNote.getPatient().getPatientId());
	        }
	        doctorNote.setPatient(patientOpt.get());

	        return doctorNoteRepository.save(doctorNote);
	    }

	    // Get all notes for a patient
	    public List<DoctorNote> getNotesByPatientId(Integer patientId) {
	        Optional<Patient> patientOpt = patientsService.getPatientById(patientId);
	        return patientOpt.map(doctorNoteRepository::findByPatient).orElse(null);
	    }
}

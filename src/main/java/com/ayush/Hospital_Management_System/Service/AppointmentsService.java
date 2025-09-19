package com.ayush.Hospital_Management_System.Service;

import java.time.LocalDate;
import java.util.List;

import com.ayush.Hospital_Management_System.Entity.Appointment;
import com.ayush.Hospital_Management_System.Entity.Doctor;
import com.ayush.Hospital_Management_System.Entity.Patient;


public interface AppointmentsService {

	    // Save an appointment
		Appointment saveAppointment(Appointment appointment);
			
		// Get all appointments
		List<Appointment> getAllAppointments();
			
		// Get appointments for a specific doctor
		List<Appointment> getAppointmentsByDoctor(Doctor doctor);
			
		// Get appointments for a specific patient
		List<Appointment> getAppointmentsByPatient(Patient patient);
			
		// Get appointments by date
		List<Appointment> getAppointmentsByDate(LocalDate date);
			
		// Check if an appointment already exists for a doctor
		boolean isDoctorBooked(Doctor doctor, LocalDate date);
			
		// Check if an appointment already exists for a patient
		boolean isPatientBooked(Patient patient, LocalDate date);
		
		// Update an existing appointment
		Appointment updateAppointment(int appointmentId, Appointment updatedAppointment);
		
		// get Appointment of patient 
		List<Appointment> getAppointmentsByPatientId(int patientId);
		
		// get Appointment of doctor 
		List<Appointment> getAppointmentsByDoctorId(int doctorId);
		
}

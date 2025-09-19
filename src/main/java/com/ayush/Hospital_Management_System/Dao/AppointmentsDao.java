package com.ayush.Hospital_Management_System.Dao;

import java.time.LocalDate;
import java.util.List;

import com.ayush.Hospital_Management_System.Entity.Appointment;
import com.ayush.Hospital_Management_System.Entity.Doctor;
import com.ayush.Hospital_Management_System.Entity.Patient;


public interface AppointmentsDao {

	    // Save an appointment
		Appointment saveAppointmentDao(Appointment appointment);
		
		// Get all appointments
		List<Appointment> getAllAppointmentsDao();
		
		// Get appointments for a specific doctor
		List<Appointment> getAppointmentsByDoctorDao(Doctor doctor);
		
		// Get appointments for a specific patient
		List<Appointment> getAppointmentsByPatientDao(Patient patient);
		
		// Get appointments by date
		List<Appointment> getAppointmentsByDateDao(LocalDate date);
		
		// Check if an appointment already exists for a doctor
		boolean isDoctorBookedDao(Doctor doctor, LocalDate date);
		
		// Check if an appointment already exists for a patient
		boolean isPatientBookedDao(Patient patient, LocalDate date);
		
		Appointment updateAppointmentDao(int appointmentId, Appointment updatedAppointment);
		
		List<Appointment> getAppointmentsByPatientIdDao(int patientId);
		
		List<Appointment> getAppointmentsByDoctorIdDao(int doctorId);
}

package com.ayush.Hospital_Management_System.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ayush.Hospital_Management_System.Entity.Appointment;
import com.ayush.Hospital_Management_System.Entity.Doctor;
import com.ayush.Hospital_Management_System.Entity.Patient;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer>{

	// Find all appointments for a specific doctor
    List<Appointment> findByDoctor(Doctor doctor);

    // Find all appointments for a specific patient
    List<Appointment> findByPatient(Patient patient);

    // Find appointments by a specific date
    List<Appointment> findByAppointmentDate(LocalDate appointmentDate);

    // Check if an appointment exists for a doctor on a given date
    boolean existsByDoctorAndAppointmentDate(Doctor doctor, LocalDate appointmentDate);

    // Check if an appointment exists for a patient on a given date
    boolean existsByPatientAndAppointmentDate(Patient patient, LocalDate appointmentDate);
}

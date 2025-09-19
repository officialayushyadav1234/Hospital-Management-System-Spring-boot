package com.ayush.Hospital_Management_System.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ayush.Hospital_Management_System.Entity.Appointment;
import com.ayush.Hospital_Management_System.Service.AppointmentsService;


@RestController
@RequestMapping("/api/appointment")
@CrossOrigin(value = "http://localhost:5173")
public class AppointmentController {

	@Autowired
	private AppointmentsService service;
	
	@PostMapping
    public Appointment createAppointment(@RequestBody Appointment appointment) {
		
		if (service.isDoctorBooked(appointment.getDoctor(), appointment.getAppointmentDate())) {
			throw new RuntimeException("Doctor is already booked on this date.");
		}
		if (service.isPatientBooked(appointment.getPatient(), appointment.getAppointmentDate())) {
			throw new RuntimeException("Patient already has an appointment on this date.");
		}
		return service.saveAppointment(appointment);
	}
	
	@GetMapping
    public List<Appointment> getAllAppointments() {
		return service.getAllAppointments();
	}
	
	// Get appointments by date
    @GetMapping(value = "/date")
    public List<Appointment> getAppointmentsByDate(@RequestParam String date) {
    	return service.getAppointmentsByDate(LocalDate.parse(date));
    }
    
    
    // Update an existing appointment
    @PutMapping("/{appointmentId}")
    public Appointment updateAppointment(@PathVariable int appointmentId, @RequestBody Appointment updatedAppointment) {
        return service.updateAppointment(appointmentId, updatedAppointment);   		
    }
    
    @GetMapping(value = "/patientId/{patientId}")
    public List<Appointment> getAppointmentsByPatientId(@PathVariable int patientId) {
    	return service.getAppointmentsByPatientId(patientId);
    }
    
    @GetMapping(value = "/doctorId/{doctorId}")
    public List<Appointment> getAppointmentsByDoctorId(@PathVariable int doctorId) {
    	return service.getAppointmentsByDoctorId(doctorId);
    	
    }
	
}

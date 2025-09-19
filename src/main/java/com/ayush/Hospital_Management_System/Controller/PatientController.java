package com.ayush.Hospital_Management_System.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ayush.Hospital_Management_System.Entity.Patient;
import com.ayush.Hospital_Management_System.Service.PatientsService;


@RestController
@RequestMapping("/api/patient")
@CrossOrigin(value = "http://localhost:5173")

public class PatientController {

	   @Autowired
	    private PatientsService service;

	    @PostMapping
	    public Patient savePatientController(@RequestBody Patient patient) {
	    	System.out.println(patient);
	        return service.savePatient(patient);
	    }
	    
	    @GetMapping
	    public List<Patient> getAllPatientController() {
	    	return service.getAllPatient();
	    }
	    
	    @GetMapping(value = "/{id}")
	    public Optional<Patient> getPatientByIdController(@PathVariable int id) {
			return service.getPatientById(id);
		}
	    
	    @GetMapping(value = "/contactNumber/{contactNumber}")
	    public Patient findByContactNumberController(@PathVariable String contactNumber) {
	    	return service.findByContactNumber(contactNumber);
	    }
	    
	    
	    @GetMapping(value = "/email/{email}")
	    public Patient findByEmailController(@PathVariable String email) {
	    	return service.findByEmail(email);
	    }
	    
	    @PostMapping(value = "/exists/{email}")
	    public boolean existsByEmailController(@PathVariable String email) {
	    	return service.existsByEmail(email);
	    }
	    
	    @PostMapping(value = "/auth")
	    public boolean authenticatePatientCredentialsController(@RequestParam int patientId, @RequestParam String password) {
	    	return service.authenticatePatientCredentials(patientId, password);
	    }
}

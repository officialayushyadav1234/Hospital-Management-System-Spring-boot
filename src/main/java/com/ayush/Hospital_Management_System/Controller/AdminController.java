package com.ayush.Hospital_Management_System.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayush.Hospital_Management_System.Service.AdminService;

@RestController
@RequestMapping(value = "/api/authenticateAdmin")
@CrossOrigin(value = "http://localhost:5173")
public class AdminController {

	@Autowired
	private AdminService service;
	
	@PostMapping(value = "/identifier/{identifier}/password/{password}")
	public boolean authenticateAdminController(@PathVariable String identifier, @PathVariable String password) {
		return service.authenticateAdmin(identifier, password);
	}
}

package com.ayush.Hospital_Management_System.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ayush.Hospital_Management_System.Entity.Doctor;

public interface DoctorReposetory   extends JpaRepository<Doctor, Long>  {
   
     //Find doctor by email
     Doctor findByEmail(String email);

     // Find doctor by contact number
     Doctor findByContactNumber(String contactNumber);

     // Find doctors by specialization  
     List<Doctor> findBySpecialization(String specialization);

     // Check if a doctor exists by email
     boolean existsByEmail(String email);

     // Check if a doctor exists by contact number
     boolean existsByContactNumber(String contactNumber);

     // Find doctor by ID and password
     Optional<Doctor> findByDoctorIdAndPassword(Long doctorId, String password);

}
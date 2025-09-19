package com.ayush.Hospital_Management_System.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ayush.Hospital_Management_System.Entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{

	boolean existsByIdAndPassword(int id, String password);

    boolean existsByEmailAndPassword(String email, String password);

}

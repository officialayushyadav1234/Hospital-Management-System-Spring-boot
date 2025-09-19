package com.ayush.Hospital_Management_System.Dao;

import org.springframework.stereotype.Repository;

import com.ayush.Hospital_Management_System.Repository.AdminRepository;

@Repository
public class AdminImpl  implements AdminDao {

private AdminRepository repository;
	
	/**
	 * @param repository
	 */
	public AdminImpl(AdminRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public boolean getAdminByIdAndPassword(int adminId, String password) {
		return repository.existsByIdAndPassword(adminId, password);
	}

	@Override
	public boolean getAdminByEmailAndPassword(String email, String password) {
		return repository.existsByEmailAndPassword(email, password);
	}
}

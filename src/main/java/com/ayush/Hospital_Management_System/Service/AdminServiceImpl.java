package com.ayush.Hospital_Management_System.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayush.Hospital_Management_System.Dao.AdminDao;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminDao dao;

	@Override
	public boolean authenticateAdmin(String identifier, String password) {
		try {
            int adminId = Integer.parseInt(identifier);
            return dao.getAdminByIdAndPassword(adminId, password);
        } catch (NumberFormatException e) {
            return dao.getAdminByEmailAndPassword(identifier, password);
        }
	}
}

package com.ayush.Hospital_Management_System.Dao;

public interface AdminDao {

	boolean getAdminByIdAndPassword(int adminId, String password);

    boolean getAdminByEmailAndPassword(String email, String password);
}

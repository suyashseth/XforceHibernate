package com.dev.dao;

import com.dev.beans.UserInfo;

public class HibernateImpl implements UserInfoDAO {

	@Override
	public boolean CreateProfile(UserInfo user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserInfo SearchStudent(int id, String pass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean UpdatePassword(int id, String Opassword, String npass, String npass2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean DeleteUser(int id, String password) {
		// TODO Auto-generated method stub
		return false;
	}


	}


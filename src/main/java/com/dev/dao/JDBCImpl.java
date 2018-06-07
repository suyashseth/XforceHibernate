package com.dev.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.dev.beans.UserInfo;


public class JDBCImpl implements UserInfoDAO{

	@Override
	public boolean CreateProfile(UserInfo user) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			
			System.out.println("ok");
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("ok2");
			String dburl = "jdbc:mysql://localhost:3306/xforce?user=root&password=1234";
			con = DriverManager.getConnection(dburl);
			System.out.println("connected");
			
			String query  = "insert into user_info values(?,?,?,?,?)";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1,user.getUser_id());
			pstmt.setString(2,user.getFirstname());
			pstmt.setString(3,user.getLastname());
			pstmt.setString(4,user.getEmail());
			pstmt.setString(5,user.getPassword());
			
			int count = pstmt.executeUpdate();
			if(count>0)
			{
				return true;
			}
			else
			{
                return false;
			}
		
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			try 
	    	 {
	    	  if(con!=null) {
	    		  con.close();
	    	  }
	    	  if(pstmt!=null) {
	    		  pstmt.close();
	    	  }
	    	
	    	 }
	    	 catch(Exception e)
	    	 {
	    		 e.printStackTrace();
	    	 }
	     }
		return false;
	}
			
	

	@Override
	public UserInfo SearchStudent(int id,String pass) {
		
		Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        UserInfo us = new UserInfo();
        try {
        	
        Class.forName("com.mysql.jdbc.Driver");
        
        String dburl = "jdbc:mysql://localhost:3306/xforce?user=root&password=1234";
        con = DriverManager.getConnection(dburl);
        
        String query = "select user_id,firstname,lastname,email from user_info "
        		+ " where user_id=? and password=?";
        pstmt = con.prepareStatement(query);
        pstmt.setInt(1,id);
        pstmt.setString(2, pass);
        rs = pstmt.executeQuery(); 
       
        if(rs.next()) {
			int regno1 = rs.getInt("user_id");
			String firstname = rs.getString("firstname");
			String lastname = rs.getString("lastname");
			String email = rs.getString("email");

			us.setUser_id(regno1);
			us.setFirstname(firstname);
			us.setLastname(lastname);
			us.setEmail(email);
        }}
        catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			 try 
	    	 {
	    	  if(con!=null) {
	    		  con.close();
	    	  }
	    	  if(pstmt!=null) {
	    		  pstmt.close();
	    	  }
	    	
	    	 }
	    	 catch(Exception e)
	    	 {
	    		 e.printStackTrace();
	    	 }
	     }
		return us;
		
		
		
			
	}

	@Override
	public boolean UpdatePassword(int regno,String pass, String pass1, String pass2 ) {
		
		
		if(pass1.equals(pass2)) {
			
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			
		Class.forName("com.mysql.jdbc.Driver");
		
		String dburl = "jdbc:mysql://localhost:3306/xforce";
		con = DriverManager.getConnection(dburl);
		
		String query = "update user_info set password=? where regno=? and password=?";
		pstmt = con.prepareStatement(query);
		pstmt.setString(1,pass1);
		pstmt.setInt(2,regno);
		pstmt.setString(3,pass);
		
		int count = pstmt.executeUpdate();
		
		if(count>0)
		{
			System.out.println("Successfull");
		}
		else
		{
			System.out.println("unsuccessfull");
		}
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			 try 
	    	 {
	    	  if(con!=null) {
	    		  con.close();
	    	  }
	    	  if(pstmt!=null) {
	    		  pstmt.close();
	    	  }
	    	
	    	 }
	    	 catch(Exception e)
	    	 {
	    		 e.printStackTrace();
	    	 }
	     }
		}
		
		
		
		else {
			System.out.println("password mismatch");
			
		}
		
		
		
		return false;
	}

	@Override
	public boolean DeleteUser(int id, String password) {
		
		Connection con = null;
	     PreparedStatement pstmt = null;
	     
	     try {
	    	
	    	 Class.forName("com.mysql.jdbc.Driver");
				
			 String dburl = "jdbc:mysql://localhost:3306/xforce";
			 con = DriverManager.getConnection(dburl);
			
			 String query = "Delete from user_info where regno=? and password=?";
			 pstmt = con.prepareStatement(query);
			 pstmt.setInt(1,id);
			 pstmt.setString(2,password);
			 
			 int count = pstmt.executeUpdate();
			 
			 if(count>0)
			 {
				 System.out.println("successfull");
			 }
			 else {
				 System.out.println("unsuccessfull");
			 }
			 
				
	     }catch(Exception e)
	     {
	    	 e.printStackTrace();
	     }finally {
	    	 try 
	    	 {
	    	  if(con!=null) {
	    		  con.close();
	    	  }
	    	  if(pstmt!=null) {
	    		  pstmt.close();
	    	  }
	    	
	    	 }
	    	 catch(Exception e)
	    	 {
	    		 e.printStackTrace();
	    	 }
	     }
		
		return false;
	}
	public String toString()
	{
	return "JDBC";	
	}

}

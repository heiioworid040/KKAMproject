package com.kkam.user.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class LoginDAO {
	public Connection getConnection() throws Exception {
	Context init=new InitialContext();
	DataSource ds=(DataSource)init.lookup("java:comp/env/jdbc/MysqlDB");
	Connection con=ds.getConnection();
	return con;
	}//getConnection()
	
	public UserDTO Login(String id, String pw) {
		UserDTO dto=null;
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con = getConnection();
		     String sql="select * from user where U_id=? and U_pw=?";
			 pstmt=con.prepareStatement(sql);
			 pstmt.setString(1,id);
			 pstmt.setString(2,pw);
			 rs=pstmt.executeQuery(); 
			 
			 if(rs.next()){
				dto=new UserDTO(); 
				dto.setU_id(rs.getString("id"));
				dto.setU_pw(rs.getString("pw"));
			 }else{
				 
			 }
		}catch (Exception e) {	
			e.printStackTrace();
		}
		finally {
			if(pstmt!=null)try {pstmt.close();} catch (Exception e2) {}
			if(con!=null)try {con.close();} catch (Exception e2) {}
			if(rs!=null)try {rs.close();} catch (Exception e2) {}

		}
		return dto;
	}//userCheck()
	
}

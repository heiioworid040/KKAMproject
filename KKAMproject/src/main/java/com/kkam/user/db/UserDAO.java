package com.kkam.user.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class UserDAO {

	public Connection getConnection() throws Exception{
		Context init=new InitialContext();
		DataSource ds=(DataSource)init.lookup("java:comp/env/jdbc/MysqlDB");
		Connection con=ds.getConnection();
		return con;
	}
	public void insertUser(UserDTO dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con=getConnection();
			String sql="insert into user"
				    	+ "(U_id, U_pw, U_name, U_nick, U_birth, U_phone, U_email, U_grade, U_address, U_addressD)"
					    + "values(?,?,?,?,?,?,?,'일반',?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getU_id());
			pstmt.setString(2, dto.getU_pw());
			pstmt.setString(3, dto.getU_name());
			pstmt.setString(4, dto.getU_nick());
			pstmt.setInt(5, dto.getU_birth());
			pstmt.setInt(6, dto.getU_phone());
			pstmt.setString(7, dto.getU_email());
			pstmt.setString(8, dto.getU_address());
			pstmt.setString(9, dto.getU_addressD());
			pstmt.executeUpdate();	
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (pstmt != null) try {pstmt.close();} catch (Exception e2) {}
			if (con != null) try {con.close();} catch (Exception e2) {}
		}
	}
	

	public UserDTO getUser(String id) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		UserDTO dto=null;
		try {
			con=getConnection();
			String sql="select * from user where U_id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);

			rs=pstmt.executeQuery();
			if(rs.next()){
				dto = new UserDTO();
				dto.setU_id(rs.getString("id"));
				dto.setU_pw(rs.getString("pw"));
				dto.setU_name(rs.getString("name"));
				dto.setU_nick(rs.getString("nick"));
				dto.setU_birth(rs.getInt("birth"));
				dto.setU_createdate(rs.getTimestamp("createdate"));
				dto.setU_phone(rs.getInt("phone"));
				dto.setU_email(rs.getString("email"));
				dto.setU_grade(rs.getString("grade"));
				dto.setU_address(rs.getString("address"));
				dto.setU_addressD(rs.getString("addressD"));
				

			}else{
				
			}	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) try { rs.close();} catch (Exception e2) {}
			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {}
			if(con!=null) try { con.close();} catch (Exception e2) {}
		}
		return dto;
	}
		
	public UserDTO getUser_nick(String nick) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		UserDTO dto=null;
		try {
			con=getConnection();
			String sql="select * from user where U_nick=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, nick);

			rs=pstmt.executeQuery();
			if(rs.next()){
				dto = new UserDTO();
				dto.setU_id(rs.getString("id"));
				dto.setU_pw(rs.getString("pw"));
				dto.setU_name(rs.getString("name"));
				dto.setU_nick(rs.getString("nick"));
				dto.setU_birth(rs.getInt("birth"));
				dto.setU_createdate(rs.getTimestamp("createdate"));
				dto.setU_phone(rs.getInt("phone"));
				dto.setU_email(rs.getString("email"));

				dto.setU_grade(rs.getString("grade"));
				dto.setU_address(rs.getString("address"));
				dto.setU_addressD(rs.getString("addressD"));

			}else{
				
			}	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) try { rs.close();} catch (Exception e2) {}
			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {}
			if(con!=null) try { con.close();} catch (Exception e2) {}
		}
		return dto;
	}

	

	

}

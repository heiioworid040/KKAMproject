package com.kkam.notice.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class NoticeDAO {
	public Connection getConnection() throws Exception{
		Context init=new InitialContext();
		DataSource ds=(DataSource)init.lookup("java:comp/env/jdbc/MysqlDB");
		Connection con=ds.getConnection();
		return con;
	}
	
	public void insertNotice(NoticeDTO dto) {
		System.out.println("NoticeDAO insertNotice()");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			int num = 1;
			String sql="select max(N_num) from notice";
			pstmt = con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				num=rs.getInt("max(N_num)")+1;
			}
			sql="insert into Notice(N_num, U_nick, U_id, N_title, N_text, N_date, N_img, N_view )"
				+ "values(?,?,?,?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, dto.getU_nick());
			pstmt.setString(3, dto.getU_id());
			pstmt.setString(3, dto.getN_title());
			pstmt.setString(4, dto.getN_text());
			pstmt.setTimestamp(5, dto.getN_date());
			pstmt.setString(6, dto.getN_img());
			pstmt.setInt(5, dto.getN_view());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 예외 상관없이 마무리작업 => 객체생성한 기억장소 해제
			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {}
			if(con!=null) try { con.close();} catch (Exception e2) {}
		}
		return;
	}
		
	
}

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
	
	public void userCheck(String id, String pw) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=getConnection();
			String sql="select * from user where U_id=? and U_pw=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs=pstmt.executeQuery();
			if(rs.next()){
				UserDTO dto=new UserDTO();
				dto.setU_id(rs.getString("id"));
				dto.setU_pw(rs.getString("pw"));
				dto.setU_name(rs.getString("name"));

			}else{
				//next() 다음행 =>       데이터 없으면 false => 아이디 비밀번호 틀림
			    // 	           => script   "아이디 비밀번호 틀림" 뒤로이동
				// 바구니주소 null 초기값 설정
			}	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 예외 상관없이 마무리작업 => 객체생성한 기억장소 해제
			if(rs!=null) try { rs.close();} catch (Exception e2) {}
			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {}
			if(con!=null) try { con.close();} catch (Exception e2) {}
		}
		return dto;
	}
		
	

	

}
}
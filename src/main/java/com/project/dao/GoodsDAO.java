//package com.kkam.goods.db;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//
//import javax.naming.Context;
//import javax.naming.InitialContext;
//import javax.sql.DataSource;
//
//public class GoodsDAO {
//	public Connection getConnection() throws Exception {
//	Context init=new InitialContext();
//	DataSource ds=(DataSource)init.lookup("java:comp/env/jdbc/MysqlDB");
//	Connection con=ds.getConnection();
//	return con;
//	}//getConnection()
//	
//	public void insertGoods(GoodsDTO dto) {
//		Connection con=null;
//		PreparedStatement pstmt=null;
//		try {
//			con=getConnection();
//			String sql="insert into goods(G_code, G_stop, G_product, G_price, G_desc, G_imgS, G_img) values(?, ?, ?, ?, ?, ?, ?)";
//			pstmt=con.prepareStatement(sql);
//			pstmt.setString(1, dto.getG_code());
//			pstmt.setInt(2, dto.getG_stop());
//			pstmt.setString(3, dto.getG_product());
//			pstmt.setInt(4, dto.getG_price());
//			pstmt.setString(5, dto.getG_desc());
//			pstmt.setString(6, dto.getG_imgS());
//			pstmt.setString(7, dto.getG_img());
//			pstmt.executeUpdate();
//		}catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			if(pstmt!=null) try { pstmt.close(); } catch (Exception e2) {}
//			if(con!=null) try { con.close(); } catch (Exception e2) {}
//		}
//		return;
//	} //insertGoods()
//	
//	public ArrayList<GoodsDTO> GoodsList() {
//		ArrayList<GoodsDTO> GoodsList=new ArrayList<GoodsDTO>();
//		GoodsDTO dto=null;
//		Connection con = null;
//		PreparedStatement pstmt=null;
//		ResultSet rs=null;
//		try {
//			con = getConnection();
//		     String sql="select * from goods";
//			 pstmt=con.prepareStatement(sql);
//			 rs=pstmt.executeQuery(); 
//			 
//			 while(rs.next()){
//				dto=new GoodsDTO(); 
//				dto.setG_imgS(rs.getString("G_imgS"));
//				dto.setG_code(rs.getString("G_code"));
//				dto.setG_product(rs.getString("G_product"));
//				dto.setG_price(rs.getInt("G_price"));
//				GoodsList.add(dto);
//			 }
//		}catch (Exception e) {	
//			e.printStackTrace();
//		}
//		finally {
//			if(pstmt!=null)try {pstmt.close();} catch (Exception e2) {}
//			if(con!=null)try {con.close();} catch (Exception e2) {}
//			if(rs!=null)try {rs.close();} catch (Exception e2) {}
//
//		}
//		return GoodsList;
//	}//GoodsList()
//	
//	public ArrayList<GoodsDTO> GoodsList(String code) {
//		ArrayList<GoodsDTO> GoodsList=new ArrayList<GoodsDTO>();
//		GoodsDTO dto=null;
//		Connection con = null;
//		PreparedStatement pstmt=null;
//		ResultSet rs=null;
//		try {
//			con = getConnection();
//		     String sql="select * from goods where G_code=?";
//			 pstmt=con.prepareStatement(sql);
//			pstmt.setString(1, code);
//			 rs=pstmt.executeQuery();
//			 
//			 while(rs.next()){
//				dto=new GoodsDTO(); 
//				dto.setG_imgS(rs.getString("G_imgS"));
//				dto.setG_img(rs.getString("G_img"));
//				dto.setG_code(rs.getString("G_code"));
//				dto.setG_product(rs.getString("G_product"));
//				dto.setG_desc(rs.getString("G_desc"));
//				dto.setG_stop(rs.getInt("G_stop"));
//				dto.setG_price(rs.getInt("G_price"));
//				GoodsList.add(dto);
//			 }
//		}catch (Exception e) {	
//			e.printStackTrace();
//		}
//		finally {
//			if(pstmt!=null)try {pstmt.close();} catch (Exception e2) {}
//			if(con!=null)try {con.close();} catch (Exception e2) {}
//			if(rs!=null)try {rs.close();} catch (Exception e2) {}
//
//		}
//		return GoodsList;
//	}//GoodsList(code)
//
//}//class

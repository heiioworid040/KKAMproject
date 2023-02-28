package com.kkam.user.db;

import java.sql.Timestamp;

public class UserDTO {

	private String U_id;
	private String U_pw;
	private String U_name;
	private String U_nick;
	private int U_birth;
	private Timestamp U_createdate;
	private int U_phone;
	private String U_email;
	private String U_emailD;
	private String U_grade;
	private String U_address;
	private String U_address2;
	
	public String getU_id() {
		return U_id;
	}
	public void setU_id(String u_id) {
		U_id = u_id;
	}
	public String getU_pw() {
		return U_pw;
	}
	public void setU_pw(String u_pw) {
		U_pw = u_pw;
	}
	public String getU_name() {
		return U_name;
	}
	public void setU_name(String u_name) {
		U_name = u_name;
	}
	public String getU_nick() {
		return U_nick;
	}
	public void setU_nick(String u_nick) {
		U_nick = u_nick;
	}
	public int getU_birth() {
		return U_birth;
	}
	public void setU_birth(int u_birth) {
		U_birth = u_birth;
	}
	public Timestamp getU_createdate() {
		return U_createdate;
	}
	public void setU_createdate(Timestamp u_createdate) {
		U_createdate = u_createdate;
	}
	public int getU_phone() {
		return U_phone;
	}
	public void setU_phone(int u_phone) {
		U_phone = u_phone;
	}
	public String getU_email() {
		return U_email;
	}
	public void setU_email(String u_email) {
		U_email = u_email;
	}
	public String getU_emailD() {
		return U_emailD;
	}
	public void setU_emailD(String u_emailD) {
		U_emailD = u_emailD;
	}
	public String getU_grade() {
		return U_grade;
	}
	public void setU_grade(String u_grage) {
		U_grade = u_grage;
	}
	public String getU_address() {
		return U_address;
	}
	public void setU_address(String u_address) {
		U_address = u_address;
	}
	public String getU_address2() {
		return U_address2;
	}
	public void setU_address2(String u_address2) {
		U_address2 = u_address2;
	}

	

}

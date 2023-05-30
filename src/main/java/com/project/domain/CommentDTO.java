package com.project.domain;

import java.sql.Timestamp;

public class CommentDTO {
	private int C_num;
	private int N_num;
	private String U_id;
	private String C_cont;
	private Timestamp C_date;
	
	public int getC_num() {
		return C_num;
	}
	public void setC_num(int c_num) {
		C_num = c_num;
	}
	public int getN_num() {
		return N_num;
	}
	public void setN_num(int n_num) {
		N_num = n_num;
	}
	public String getU_id() {
		return U_id;
	}
	public void setU_id(String u_id) {
		U_id = u_id;
	}
	public String getC_cont() {
		return C_cont;
	}
	public void setC_cont(String c_cont) {
		C_cont = c_cont;
	}
	public Timestamp getC_date() {
		return C_date;
	}
	public void setC_date(Timestamp c_date) {
		C_date = c_date;
	}
	
	
}

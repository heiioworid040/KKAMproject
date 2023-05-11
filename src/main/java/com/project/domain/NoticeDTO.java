package com.project.domain;

import java.sql.Timestamp;

public class NoticeDTO {
	
	private int N_num;
	private String U_nick;
	private String U_id;
	private String N_title;
	private String N_text;
	private Timestamp N_date;
	private String N_img;
	private int N_view;
	
	
	public int getN_num() {
		return N_num;
	}
	public void setN_num(int n_num) {
		N_num = n_num;
	}
	public String getU_nick() {
		return U_nick;
	}
	public void setU_nick(String u_nick) {
		U_nick = u_nick;
	}
	public String getU_id() {
		return U_id;
	}
	public void setU_id(String u_id) {
		U_id = u_id;
	}
	public String getN_title() {
		return N_title;
	}
	public void setN_title(String n_title) {
		N_title = n_title;
	}
	public String getN_text() {
		return N_text;
	}
	public void setN_text(String n_text) {
		N_text = n_text;
	}
	public Timestamp getN_date() {
		return N_date;
	}
	public void setN_date(Timestamp n_date) {
		N_date = n_date;
	}
	public String getN_img() {
		return N_img;
	}
	public void setN_img(String n_img) {
		N_img = n_img;
	}
	public int getN_view() {
		return N_view;
	}
	public void setN_view(int n_view) {
		N_view = n_view;
	}
	
	
}

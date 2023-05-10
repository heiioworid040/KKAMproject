package com.project.domain;

import com.google.protobuf.Timestamp;

public class BagDTO {
	private int B_num;
	private String U_id;
	private String G_code;
	private String B_count;
	private Timestamp B_date;
	public int getB_num() {
		return B_num;
	}
	public void setB_num(int b_num) {
		B_num = b_num;
	}
	public String getU_id() {
		return U_id;
	}
	public void setU_id(String u_id) {
		U_id = u_id;
	}
	public String getG_code() {
		return G_code;
	}
	public void setG_code(String g_code) {
		G_code = g_code;
	}
	public String getB_count() {
		return B_count;
	}
	public void setB_count(String b_count) {
		B_count = b_count;
	}
	public Timestamp getB_date() {
		return B_date;
	}
	public void setB_date(Timestamp b_date) {
		B_date = b_date;
	}
}
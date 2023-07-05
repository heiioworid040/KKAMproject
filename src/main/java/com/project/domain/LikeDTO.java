package com.project.domain;

import java.sql.Timestamp;

public class LikeDTO extends GoodsDTO {
	private int L_num;
	private String U_id;
	private String G_code;
	private Timestamp L_date;
	
	public int getL_num() {
		return L_num;
	}
	public void setL_num(int l_num) {
		L_num = l_num;
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
	public Timestamp getL_date() {
		return L_date;
	}
	public void setL_date(Timestamp l_date) {
		L_date = l_date;
	}
}

package com.project.domain;

import java.sql.Timestamp;
import java.util.List;

public class BasketDTO extends GoodsDTO{
	private int B_num;
	private String U_id;
	private String G_code;
	private int B_count;
	private Timestamp B_date;
	
	public static class BasketQuery {
	    private String id;
	    private List<String> ck;

	    public BasketQuery(String id, List<String> ck) {
	        this.id = id;
	        this.ck = ck;
	    }
	    
	    public String getId() {
	        return id;
	    }
		public void setU_id(String id) {
			this.id = id;
		}
		public List<String> getCk() {
			return ck;
		}
		public void setCk(List<String> ck) {
			this.ck = ck;
		}
	}
	
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
	public int getB_count() {
		return B_count;
	}
	public void setB_count(int b_count) {
		B_count = b_count;
	}
	public Timestamp getB_date() {
		return B_date;
	}
	public void setB_date(Timestamp b_date) {
		B_date = b_date;
	}
}
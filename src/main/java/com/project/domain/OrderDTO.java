package com.project.domain;

import com.google.protobuf.Timestamp;

public class OrderDTO extends BasketDTO{
	private int O_code;
	private String U_id;
	private String O_address;
	private String O_addressD;
	private int O_zipcode;
	private int O_phone;
	private int O_delivery;
	private int O_price;
	private int O_count;
	private Timestamp O_date;
	
	//상세
	private int OD_num;
	private String G_code;
	private int OD_price;
	private int OD_count;
	
	public int getO_code() {
		return O_code;
	}
	public void setO_code(int o_code) {
		O_code = o_code;
	}
	public String getU_id() {
		return U_id;
	}
	public void setU_id(String u_id) {
		U_id = u_id;
	}
	public String getO_address() {
		return O_address;
	}
	public void setO_address(String o_address) {
		O_address = o_address;
	}
	public String getO_addressD() {
		return O_addressD;
	}
	public void setO_addressD(String o_addressD) {
		O_addressD = o_addressD;
	}
	public int getO_zipcode() {
		return O_zipcode;
	}
	public void setO_zipcode(int o_zipcode) {
		O_zipcode = o_zipcode;
	}
	public int getO_phone() {
		return O_phone;
	}
	public void setO_phone(int o_phone) {
		O_phone = o_phone;
	}
	public int getO_delivery() {
		return O_delivery;
	}
	public void setO_delivery(int o_delivery) {
		O_delivery = o_delivery;
	}
	public int getO_price() {
		return O_price;
	}
	public void setO_price(int o_price) {
		O_price = o_price;
	}
	public int getO_count() {
		return O_count;
	}
	public void setO_count(int o_count) {
		O_count = o_count;
	}
	public Timestamp getO_date() {
		return O_date;
	}
	public void setO_date(Timestamp o_date) {
		O_date = o_date;
	}
	public int getOD_num() {
		return OD_num;
	}
	public void setOD_num(int oD_num) {
		OD_num = oD_num;
	}
	public String getG_code() {
		return G_code;
	}
	public void setG_code(String g_code) {
		G_code = g_code;
	}
	public int getOD_price() {
		return OD_price;
	}
	public void setOD_price(int oD_price) {
		OD_price = oD_price;
	}
	public int getOD_count() {
		return OD_count;
	}
	public void setOD_count(int oD_count) {
		OD_count = oD_count;
	}
}
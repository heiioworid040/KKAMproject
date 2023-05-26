package com.project.domain;

import java.sql.Timestamp;

public class OrderDTO extends BasketDTO{
	private String O_code;
	private String O_name;
	private int O_phone;
	private int O_delivery;
	private int O_price;
	private int O_count;
	private Timestamp O_date;
	
	//상세
	private int OD_num;
	private int OD_price;
	private int OD_count;
	
	//배송
	private int D_num;
	private String D_name;
	private String D_address;
	private String D_addressD;
	private int D_zipcode;
	private int D_phone;
	private String D_desc;
	
	
	public String getO_code() {
		return O_code;
	}
	public void setO_code(String o_code) {
		O_code = o_code;
	}
	public String getO_name() {
		return O_name;
	}
	public void setO_name(String o_name) {
		O_name = o_name;
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
	public int getD_num() {
		return D_num;
	}
	public void setD_num(int d_num) {
		D_num = d_num;
	}
	public String getD_name() {
		return D_name;
	}
	public void setD_name(String d_name) {
		D_name = d_name;
	}
	public String getD_address() {
		return D_address;
	}
	public void setD_address(String d_address) {
		D_address = d_address;
	}
	public String getD_addressD() {
		return D_addressD;
	}
	public void setD_addressD(String d_addressD) {
		D_addressD = d_addressD;
	}
	public int getD_zipcode() {
		return D_zipcode;
	}
	public void setD_zipcode(int d_zipcode) {
		D_zipcode = d_zipcode;
	}
	public int getD_phone() {
		return D_phone;
	}
	public void setD_phone(int d_phone) {
		D_phone = d_phone;
	}
	public String getD_desc() {
		return D_desc;
	}
	public void setD_desc(String d_desc) {
		D_desc = d_desc;
	}
}